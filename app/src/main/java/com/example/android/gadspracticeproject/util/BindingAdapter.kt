package com.example.android.gadspracticeproject.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.gadspracticeproject.network.TopLearner
import com.example.android.gadspracticeproject.network.TopSkillDetails
import com.example.android.gadspracticeproject.screens.gadsleaderboard.toplearners.LearnerAdapter
import com.example.android.gadspracticeproject.screens.gadsleaderboard.topskill.SkillerAdapter

@BindingAdapter("badge")
fun bindImage(imageView: ImageView,imgUrl:String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(imgUri).into(imageView)
    }
}
@BindingAdapter("learnerItem")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<TopLearner>?){
    val adapter = recyclerView.adapter as LearnerAdapter
    adapter.submitList(data)
}
@BindingAdapter("learnerHours")
fun TextView.bindHourText(item:TopLearner?){
    item?.let {
        val string = "${item.hours} learning hours, ${item.country}"
        text = string
    }
}
@BindingAdapter("learnerName")
fun TextView.bindNameText(item:TopLearner?){
    item?.let {
        text = item.name
    }
}
@BindingAdapter("skillItem")
fun bindSkillRecyclerView(recyclerView: RecyclerView,data: List<TopSkillDetails>?){
    val adapter = recyclerView.adapter as SkillerAdapter
    adapter.submitList(data)
}
@BindingAdapter("skillIQ")
fun TextView.bindSkillIQ(item:TopSkillDetails){
    val string = "${item.score} skill IQ score, ${item.country}"
    text = string
}
@BindingAdapter("skillName")
fun TextView.bindSkillName(item:TopSkillDetails){
    text = item.name
}