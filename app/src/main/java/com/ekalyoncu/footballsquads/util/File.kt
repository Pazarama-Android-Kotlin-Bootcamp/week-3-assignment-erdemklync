package com.ekalyoncu.footballsquads.util

import android.content.Context
import java.io.InputStream

// https://stackoverflow.com/a/65879428
fun readTeamsJsonData(context: Context): String? {
    var json: String? = null
    try {
        val  inputStream: InputStream = context.assets.open("teams.json")
        json = inputStream.bufferedReader().use{it.readText()}
    } catch (ex: Exception) {
        ex.printStackTrace()
        return null
    }
    return json
}