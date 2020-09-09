package com.example.android.gadspracticeproject.screens.gadsleaderboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.gadspracticeproject.screens.gadsleaderboard.toplearners.LearnerFragment
import com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill.SkillerFragment

class LeaderboardViewPager(fragment: Fragment) :FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                LearnerFragment()
            }
            1->{
                SkillerFragment()
            }
            else -> throw Exception()
        }
    }

}