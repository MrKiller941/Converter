package com.killer.converter.infrastructure.shared

import android.content.Context
import android.content.SharedPreferences
import com.killer.converter.domain.history.IConverterRepository
import com.killer.converter.domain.history.Result
import org.json.JSONArray
import org.json.JSONObject

object DatabaseResults : IConverterRepository {

    private val limit = 5
    private lateinit var preferences: SharedPreferences

    fun initialize(context: Context){
        preferences = context.getSharedPreferences("converter", Context.MODE_PRIVATE)
    }

    override fun getAll(): List<Result> {
        val json = preferences.getString("history", "[]") // По умолчанию возвращаем "пустой" список
        val resultList = mutableListOf<Result>()

        if (json != null) {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val result = fromJson(jsonArray.getString(i))
                resultList.add(result)
            }
        }

        // Убедимся, что мы не возвращаем больше элементов, чем указано в limit
        return resultList.takeLast(limit)
    }

    override fun add(result: Result) {
        val history = preferences.getString("history", "[]")
        if (history != null) {
            val jsonArray = JSONArray(history)

            if (jsonArray.length() >= limit) {
                for (i in 0 until jsonArray.length() - limit + 1) {
                    jsonArray.remove(0) // Удаляем самый старый элемент
                }
            }

            jsonArray.put(toJson(result))
            val editor = preferences.edit()
            editor.putString("history", jsonArray.toString())
            editor.apply()
        } else {
            val jsonArray = JSONArray()
            jsonArray.put(toJson(result))
            val editor = preferences.edit()
            editor.putString("history", jsonArray.toString())
            editor.apply()
        }
    }

    private fun toJson(result: Result): String {
        val json = JSONObject()
        json.put("inputBase", result.inputBase)
        json.put("outputBase", result.outputBase)
        json.put("inputNumber", result.inputNumber)
        json.put("outputNumber", result.outputNumber)
        return json.toString()
    }

    private fun fromJson(json: String): Result {
        val obj = JSONObject(json)
        val inputBase = obj.getInt("inputBase")
        val outputBase = obj.getInt("outputBase")
        val inputNumber = obj.getString("inputNumber")
        val outputNumber = obj.getString("outputNumber")
        return Result(inputBase, outputBase, inputNumber, outputNumber)
    }
}