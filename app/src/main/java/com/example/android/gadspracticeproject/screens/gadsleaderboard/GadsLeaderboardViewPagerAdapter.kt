package com.example.android.gadspracticeproject.screens.gadsleaderboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class GadsLeaderboardViewPagerAdapter(fragment: Fragment) :FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                GadsLearnerLeadersFragment()
            }
            1->{
                GadsSkillLeadersFragment()
            }
            else -> throw Exception()
        }
    }

}