package com.ekalyoncu.footballsquads.util

import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.ekalyoncu.footballsquads.R
import com.ekalyoncu.footballsquads.model.Team
import com.ekalyoncu.footballsquads.repository.PlayerRepository
import com.ekalyoncu.footballsquads.repository.TeamRepository

fun ImageView.setTeamLogo(team: Team){
    val id = TeamRepository.teamDrawables.getOrElse(team.code){ R.drawable.img_default }
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}

fun ImageView.setPlayerPhoto(team: Team){
    val id = PlayerRepository.playerDrawables.getOrElse(team.code){ R.drawable.img_default }
    val drawable = ResourcesCompat.getDrawable(resources, id, context.theme)
    this.setImageDrawable(drawable)
}