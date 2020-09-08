package com.example.android.gadspracticeproject.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.gadspracticeproject.network.TopLearner
import com.example.android.gadspracticeproject.screens.gadsleaderboard.LearnerAdapter

@BindingAdapter("learnerBadge")
fun bindImage(imageView: ImageView,imgUrl:String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(imgUri).into(imageView)
    }
}
@BindingAdapter("listItem")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<TopLearner>?){
    val adapter = recyclerView.adapter as LearnerAdapter
    adapter.submitList(data)
}
@BindingAdapter("learnerHours")
fun TextView.bindHourText(item:TopLearner?){
    item?.let {
        text = item.hours.toString()
    }
}
@BindingAdapter("learnerName")
fun TextView.bindNameText(item:TopLearner?){
    item?.let {
        text = item.name
    }
}