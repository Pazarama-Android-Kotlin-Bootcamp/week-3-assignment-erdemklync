package com.ekalyoncu.footballsquads.model

import android.graphics.Color
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val code: String = "",
    val name: String = "",
    val colorCodes: List<String>,
    val player: Player,
): Parcelable {
    fun getColorArray(): IntArray {
        return this.colorCodes.map {
            Color.parseColor(it)
        }.toIntArray()
    }
}