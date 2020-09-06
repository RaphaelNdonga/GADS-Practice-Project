package com.example.android.gadspracticeproject.screens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.ProjectSubmissionFragmentBinding

class ProjectSubmissionFragment : Fragment() {

    companion object {
        fun newInstance() = ProjectSubmissionFragment()
    }

    private lateinit var viewModel: ProjectSubmissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:ProjectSubmissionFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.project_submission_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO: Use the ViewModel
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProjectSubmissionViewModel::class.java)
    }

}