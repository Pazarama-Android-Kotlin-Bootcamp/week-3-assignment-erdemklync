package com.ekalyoncu.footballsquads.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ekalyoncu.footballsquads.R
import com.ekalyoncu.footballsquads.model.Team
import com.ekalyoncu.footballsquads.ui.listeners.TeamListener

class TeamAdapter(
    private val teamList: List<Team>,
    private val listener: TeamListener,
): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val teamLogo: ImageView = view.findViewById(R.id.item_team_logo)
        private val teamName: TextView = view.findViewById(R.id.item_team_name)

        fun bind(team: Team, listener: TeamListener){
            teamName.text = team.name
            //teamLogo

            itemView.setOnClickListener {
                listener.onClick(team)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList[position], listener)
    }

    override fun getItemCount(): Int = teamList.size

}