package com.example.makemoremeat.backups

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson

open class BackupToSharedPreference {

    fun saveObjectToSharedPreference(
        context: Context,
        preferenceFileName: String,
        serializedObjectKey: String,
        `object`: Any?
    ) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(preferenceFileName, MODE_PRIVATE)
        val sharedPreferencesEditor = sharedPreferences.edit()
        val gson = Gson()
        val serializedObject = gson.toJson(`object`)
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