package com.ekalyoncu.footballsquads.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ekalyoncu.footballsquads.R
import com.ekalyoncu.footballsquads.repository.TeamsRepository

class TeamsFragment : Fragment() {

    private val viewModel: TeamsViewModel by viewModels()

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

        teamsTitle.setOnClickListener {
            val action = TeamsFragmentDirections.actionTeamsFragmentToPlayersFragment(TeamsRepository.teamList[0])
            findNavController().navigate(action)
        }
    }

    fun initView(view: View){
        teamsTitle = view.findViewById(R.id.teams_title)
    }

}