package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentGadsLearnerLeadersBinding
import com.example.android.gadspracticeproject.databinding.GadsLeaderboardFragmentBinding

class GadsLearnerLeadersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGadsLearnerLeadersBinding>(
            inflater,
            R.layout.fragment_gads_learner_leaders,
            container,
            false
        )
        return binding.root
    }

}