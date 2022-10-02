package com.example.makemoremeat

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class BackupToSharedPreference {

    fun saveObjectToSharedPreference(
        context: Context,
        preferenceFileName: String?,
        serializedObjectKey: String?,
        `object`: Any?
    ) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(preferenceFileName, 0)
        val sharedPreferencesEditor = sharedPreferences.edit()
        val gson = Gson()
        val serializedObject = gson.toJson(`object`)
        println(serializedObject)
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject)
        sharedPreferencesEditor.apply()
    }

    fun <GenericClass> getSavedObjectFromPreference(
        context: Context,
        preferenceFileName: String?,
        preferenceKey: String?,
        classType: Class<GenericClass>?
    ): GenericClass? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(preferenceFileName, 0)
        if (sharedPreferences.contains(preferenceKey)) {
            val gson = Gson()
            return gson.fromJson(sharedPreferences.getString(preferenceKey, ""), classType)
        }
        return null
    }
}