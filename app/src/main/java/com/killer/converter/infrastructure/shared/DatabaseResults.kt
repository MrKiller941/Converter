package com.killer.converter.infrastructure.shared

import android.content.Context
import android.content.SharedPreferences
import com.killer.converter.domain.history.IConverterRepository
import com.killer.converter.domain.history.Result
import org.json.JSONArray
import org.json.JSONObject

object DatabaseResults : IConverterRepository {

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

        return resultList
    }

    override fun add(result: Result) {
        val history = preferences.getString("history", "[]")
        val jsonArray = JSONArray(history)
        jsonArray.put(toJson(result))
        val editor = preferences.edit()
        editor.putString("history", jsonArray.toString())
        editor.apply()
    }

    override fun deleteLast(count: Int) {
        val allResults = getAll().toMutableList()
        if (count == -1) {
            allResults.removeAll(allResults)
        } else {
            val numberOfResultsToDelete = minOf(count, allResults.size)
            for (i in 1..numberOfResultsToDelete) {
                allResults.removeLast()
            }
        }
        saveAllResults(allResults)
    }

    private fun saveAllResults(resultList: List<Result>) {
        val jsonArray = JSONArray()
        for (result in resultList) {
            jsonArray.put(toJson(result))
        }
        val editor = preferences.edit()
        editor.putString("history", jsonArray.toString())
        editor.apply()
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