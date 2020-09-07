package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentGadsLeaderboardBinding
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

        setHasOptionsMenu(true)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = GadsLeaderboardViewPagerAdapter(this)

        val tabs = listOf("Learning Leaders", "Skill IQ leaders")

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = tabs[position]
        }.attach()


        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.projectSubmissionFragment -> {
                findNavController().navigate(
                    GadsLeaderboardFragmentDirections.actionGadsLeaderboardFragmentToProjectSubmissionFragment()
                )
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO: Use the ViewModel
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(GadsLeaderboardViewModel::class.java)
    }
}