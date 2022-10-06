package com.ekalyoncu.footballsquads.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ekalyoncu.footballsquads.R
import com.ekalyoncu.footballsquads.model.Team
import com.ekalyoncu.footballsquads.repository.TeamsRepository
import com.ekalyoncu.footballsquads.ui.adapters.TeamAdapter
import com.ekalyoncu.footballsquads.ui.listeners.TeamListener

class TeamsFragment : Fragment() {

    private lateinit var teamsRecyclerView: RecyclerView
    private lateinit var teamsTitle: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_teams, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamsRecyclerView.adapter = TeamAdapter(
            TeamsRepository.teamList,
            object : TeamListener{
                override fun onClick(team: Team) {
                    val action = TeamsFragmentDirections.actionTeamsFragmentToPlayersFragment(team)
                    findNavController().navigate(action)
                }
            }
        )
        teamsRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initView(view: View){
        teamsTitle = view.findViewById(R.id.teams_title)
        teamsRecyclerView = view.findViewById(R.id.teams_recycler_view)
    }

}