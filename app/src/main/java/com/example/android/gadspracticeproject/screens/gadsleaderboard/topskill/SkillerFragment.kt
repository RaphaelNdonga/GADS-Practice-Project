package com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentSkillerBinding
import com.example.android.gadspracticeproject.network.TopSkillService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SkillerFragment : Fragment() {
    @Inject
    lateinit var topSkillService: TopSkillService
    private lateinit var viewModel: SkillerViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSkillerBinding>(
            inflater,
            R.layout.fragment_skiller,
            container,
            false
        )
        viewModel = ViewModelProvider(
            this,
            SkillerViewModelFactory((topSkillService))
        ).get(SkillerViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = SkillerAdapter()
        binding.skillerRecyclerView.adapter = adapter



        return binding.root
    }

}
