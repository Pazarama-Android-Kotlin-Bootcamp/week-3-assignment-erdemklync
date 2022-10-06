package com.ekalyoncu.footballsquads.ui.players

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ekalyoncu.footballsquads.R

class PlayersFragment : Fragment() {

    private val viewModel: PlayersViewModel by viewModels()

    private val arguments: PlayersFragmentArgs by navArgs()

    private lateinit var playersConstraintLayout: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_players, container, false)

        playersConstraintLayout = view.findViewById(R.id.players_constraint_layout)

        val team = arguments.team

        val gradient = GradientDrawable(
            GradientDrawable.Orientation.BR_TL,
            team.getColorArray(),
        ).also {
            it.cornerRadius = 0f
        }

        playersConstraintLayout.background = gradient

        return view
    }
}