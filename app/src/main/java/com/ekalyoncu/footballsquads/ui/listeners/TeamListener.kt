package com.ekalyoncu.footballsquads.ui.listeners

import com.ekalyoncu.footballsquads.model.Team

interface TeamListener {
    fun onClick(team: Team)
}