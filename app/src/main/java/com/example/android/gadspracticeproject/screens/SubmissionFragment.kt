package com.example.android.gadspracticeproject.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.gadspracticeproject.R
import com.example.android.gadspracticeproject.databinding.FragmentSubmissionBinding
import com.example.android.gadspracticeproject.util.EventObserver

class SubmissionFragment : Fragment() {

    companion object {
        fun newInstance() = SubmissionFragment()
    }

    private lateinit var viewModel: SubmissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSubmissionBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_submission,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(SubmissionViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.navigator.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                SubmissionFragmentDirections
                    .actionProjectSubmissionFragmentToGadsLeaderboardFragment()
            )
        })
        viewModel.submissionStatus.observe(viewLifecycleOwner,EventObserver{ status->
            when(status){
                SubmissionStatus.CONFIRM ->{
                    Log.i("SubmissionFragment","showing confirmation dialog....")
                    showConfirmationDialog()                }
                SubmissionStatus.SUCCESSFUL -> {
                    Log.i("SubmissionFragment","showing successful dialog....")
                    showSuccessfulDialog()
                    viewModel.navigateToLeaderboard()
                }
                SubmissionStatus.UNSUCCESSFUL -> {
                    Log.i("SubmissionFragment","showing unsuccessful dialog....")
                    showUnsuccessfulDialog()
                }
            }

        })

        return binding.root
    }
    private fun showConfirmationDialog(){
        val layoutInflater = LayoutInflater.from(this.context)
        val dialogView = layoutInflater.inflate(R.layout.dialog_confirmation,null)
        val confirmationDialog = AlertDialog.Builder(requireActivity()).create()
        confirmationDialog.setView(dialogView)
        dialogView.findViewById<View>(R.id.confirmation_yes_btn).setOnClickListener{
            viewModel.submitProject()
            confirmationDialog.dismiss()
        }
        dialogView.findViewById<View>(R.id.confirmation_cancel_btn).setOnClickListener {
            confirmationDialog.dismiss()
        }
        confirmationDialog.show()
    }
    private fun showUnsuccessfulDialog(){
        val layoutInflater = LayoutInflater.from(this.context)
        val dialogView = layoutInflater.inflate(R.layout.dialog_unsuccessful,null)
        val unsuccessfulDialog = AlertDialog.Builder(requireActivity()).create()
        unsuccessfulDialog.setView(dialogView)
        unsuccessfulDialog.show()
    }
    private fun showSuccessfulDialog(){
        val layoutInflater = LayoutInflater.from(this.context)
        val dialogView = layoutInflater.inflate(R.layout.dialog_successful,null)
        val successfulDialog = AlertDialog.Builder(requireActivity()).create()
        successfulDialog.setView(dialogView)
        successfulDialog.show()
    }
}