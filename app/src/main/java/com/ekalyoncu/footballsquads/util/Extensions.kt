package com.ekalyoncu.footballsquads.util

import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.ekalyoncu.footballsquads.model.Team

fun ImageView.setTeamLogo(team: Team){
    val id = resources.getIdentifier("img_team_${team.code}", "drawable", context.packageName)
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}

fun ImageView.setPlayerPhoto(team: Team){
    val id = resources.getIdentifier("img_player_${team.code}", "drawable", context.packageName)
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}