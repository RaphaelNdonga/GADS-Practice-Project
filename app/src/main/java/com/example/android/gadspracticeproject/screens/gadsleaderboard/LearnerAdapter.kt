package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gadspracticeproject.databinding.CardLearnerBinding
import com.example.android.gadspracticeproject.network.TopLearner

class LearnerAdapter:ListAdapter<TopLearner,LearnerAdapter.ViewHolder>(DiffUtilCallBack()){
    class ViewHolder(private val binding:CardLearnerBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(currentLearner: TopLearner) {
            binding.executePendingBindings()
            binding.learnerDetails = currentLearner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardLearnerBinding.inflate(layoutInflater))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentLearner = getItem(position)
        holder.bind(currentLearner)
    }
}

class DiffUtilCallBack:DiffUtil.ItemCallback<TopLearner>() {
    override fun areItemsTheSame(oldItem: TopLearner, newItem: TopLearner): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: TopLearner,
        newItem: TopLearner
    ): Boolean {
        return  oldItem.country == newItem.country &&
                oldItem.hours == newItem.hours &&
                oldItem.name == newItem.name
    }

}
