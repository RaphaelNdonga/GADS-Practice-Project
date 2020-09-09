package com.example.android.gadspracticeproject.screens.gadsleaderboard.toplearners

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentLearnerBinding
import com.example.android.gadspracticeproject.network.TopLearnersService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LearnerFragment : Fragment() {
    @Inject
    lateinit var topLearnersService: TopLearnersService
    private lateinit var viewModel: LearnerViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLearnerBinding>(
            inflater,
            R.layout.fragment_learner,
            container,
            false
        )
        viewModel = ViewModelProvider(this, LearnerViewModelFactory(topLearnersService)).get(
            LearnerViewModel::class.java
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.learnerRecyclerView.adapter = LearnerAdapter()

        return binding.root
    }
}
