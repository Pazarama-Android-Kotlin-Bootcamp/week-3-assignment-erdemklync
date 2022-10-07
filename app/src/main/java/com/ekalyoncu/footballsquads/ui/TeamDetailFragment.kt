package com.ekalyoncu.footballsquads.ui

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ekalyoncu.footballsquads.R
import com.ekalyoncu.footballsquads.model.Team
import com.ekalyoncu.footballsquads.util.setTeamLogo

class TeamDetailFragment : Fragment() {

    private val arguments: TeamDetailFragmentArgs by navArgs()

    private lateinit var team: Team

    private lateinit var playersConstraintLayout: ConstraintLayout
    private lateinit var teamLogo: ImageView
    private lateinit var teamName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        team = arguments.team
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_team_detail, container, false)
        initView(view)

        val gradient = GradientDrawable(
            GradientDrawable.Orientation.BR_TL,
            team.getColorArray(),
        ).also {
            it.cornerRadius = 0f
        }

        playersConstraintLayout.background = gradient

        return view
    }

    private fun initView(view: View){
        playersConstraintLayout = view.findViewById(R.id.players_constraint_layout)
        teamLogo = view.findViewById(R.id.detail_team_logo)
        teamName = view.findViewById(R.id.detail_team_name)

        teamLogo.setTeamLogo(team)
        teamName.text = team.name
    }
}