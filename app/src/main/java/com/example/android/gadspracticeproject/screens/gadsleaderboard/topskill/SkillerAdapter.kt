package com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gadspracticeproject.databinding.CardSkillerBinding
import com.example.android.gadspracticeproject.network.TopSkillDetails

class SkillerAdapter:androidx.recyclerview.widget.ListAdapter<TopSkillDetails,SkillerAdapter.ViewHolder>(DiffUtilCallBack) {

    class ViewHolder(private val binding:CardSkillerBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(topSkillDetails: TopSkillDetails) {
            binding.topSkiller = topSkillDetails
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardSkillerBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
    companion object DiffUtilCallBack:DiffUtil.ItemCallback<TopSkillDetails>(){
        override fun areItemsTheSame(oldItem: TopSkillDetails, newItem: TopSkillDetails): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TopSkillDetails,
            newItem: TopSkillDetails
        ): Boolean {
            return oldItem.country == newItem.country &&
                    oldItem.name == newItem.name &&
                    oldItem.score == newItem.score
        }

    }
}