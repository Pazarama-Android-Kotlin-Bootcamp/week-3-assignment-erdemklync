package com.ekalyoncu.footballsquads.model

import android.graphics.Color
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val code: String = "",
    val name: String = "",
    val primaryColor: String,
    val secondaryColor: String,
    val player: Player,
): Parcelable {
    fun getColorArray(): IntArray {
        return intArrayOf(
            Color.parseColor(this.primaryColor),
            Color.parseColor(this.secondaryColor),
        )
    }
}