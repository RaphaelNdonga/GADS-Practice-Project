package com.example.android.gadspracticeproject.screens.gadsleaderboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.GadsLeaderboardFragmentBinding
import com.example.android.gadspracticeproject.screens.ProjectSubmissionFragment
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
        val binding: GadsLeaderboardFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.gads_leaderboard_fragment, container, false)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = GadsLeaderboardViewPagerAdapter(this)

        val tabs = listOf("Learning Leaders", "Skill IQ leaders")

        viewPager.adapter =  adapter

        TabLayoutMediator(tabLayout,viewPager){ tab: TabLayout.Tab, position: Int ->
            tab.text = tabs[position]
        }.attach()


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.projectSubmissionFragment->{
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