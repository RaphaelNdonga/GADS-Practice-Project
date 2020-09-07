package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentGadsLearnerLeadersBinding

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
