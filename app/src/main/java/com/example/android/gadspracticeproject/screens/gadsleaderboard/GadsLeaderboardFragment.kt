package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentGadsLeaderboardBinding
import com.example.android.gadspracticeproject.util.EventObserver
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GadsLeaderboardFragment : Fragment() {

    companion object {
        fun newInstance() = GadsLeaderboardFragment()
    }

    private lateinit var viewModel: GadsLeaderboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGadsLeaderboardBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_gads_leaderboard, container, false)

        viewModel = ViewModelProvider(this).get(GadsLeaderboardViewModel::class.java)
        setHasOptionsMenu(true)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val submitBtn = binding.navigateBtn
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = GadsLeaderboardViewPagerAdapter(this)
        val tabs = listOf("Learning Leaders", "Skill IQ leaders")
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = tabs[position]
        }.attach()

        viewModel.navigator.observe(viewLifecycleOwner, EventObserver{
            Log.i("GADS LEADERBOARD", "We're in the navigator observer")
            findNavController().navigate(
                GadsLeaderboardFragmentDirections.
                actionGadsLeaderboardFragmentToProjectSubmissionFragment()
            )
        })

        return binding.root
    }
}