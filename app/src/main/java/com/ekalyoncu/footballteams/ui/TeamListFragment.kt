package com.ekalyoncu.footballteams.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ekalyoncu.footballteams.R
import com.ekalyoncu.footballteams.model.Team
import com.ekalyoncu.footballteams.repository.TeamRepository
import com.ekalyoncu.footballteams.ui.adapters.TeamAdapter
import com.ekalyoncu.footballteams.ui.listeners.TeamListener

class TeamListFragment: Fragment() {

    private lateinit var teamsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_team_list, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamsRecyclerView.adapter = TeamAdapter(
            TeamRepository.getTeamList(requireContext()),
            object : TeamListener{
                override fun onClick(team: Team) {
                    val action = TeamListFragmentDirections.actionTeamListFragmentToTeamDetailFragment(team)
                    findNavController().navigate(action)
                }
            }
        )

        teamsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun initView(view: View){
        teamsRecyclerView = view.findViewById(R.id.teams_recycler_view)
    }
}