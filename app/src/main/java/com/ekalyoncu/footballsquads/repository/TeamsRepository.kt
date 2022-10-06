package com.ekalyoncu.footballsquads.repository

import com.ekalyoncu.footballsquads.model.Team

object TeamsRepository {

    val teamList = listOf(
        Team(
            code = "fb",
            name = "Fenerbahçe",
            colorCodes = listOf("#FFFF00", "#0023A3")
        )
    )

}