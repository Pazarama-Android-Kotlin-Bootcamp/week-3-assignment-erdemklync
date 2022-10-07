package com.ekalyoncu.footballsquads.repository

import android.content.Context
import com.ekalyoncu.footballsquads.model.Team
import com.ekalyoncu.footballsquads.util.readTeamsJsonData
import com.google.gson.Gson

object TeamsRepository {

    fun getTeamList(context: Context): List<Team> {

        val teamsJsonData = readTeamsJsonData(context)

        val teamsArray = Gson().fromJson(
            teamsJsonData,
            Array<Team>::class.java,
        )

        return teamsArray.toList()
    }
}