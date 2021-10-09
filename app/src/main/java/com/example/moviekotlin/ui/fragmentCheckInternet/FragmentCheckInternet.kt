package com.example.moviekotlin.ui.fragmentCheckInternet

import android.net.Network
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moviekotlin.R
import com.example.moviekotlin.base.BaseFragment
import com.example.moviekotlin.databinding.FragmentCheckInternetBinding
import com.example.moviekotlin.ui.networkCheck.NetworkConnection

class FragmentCheckInternet :
    BaseFragment<FragmentCheckInternetBinding>(FragmentCheckInternetBinding::inflate) {

    override fun checkInternet() {
        NetworkConnection(requireActivity().application).observe(viewLifecycleOwner, { connect ->
            if (connect) {
                findNavController().navigateUp()
            }
        })
    }


}