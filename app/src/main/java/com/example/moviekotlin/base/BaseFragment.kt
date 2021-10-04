package com.example.moviekotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding : ViewBinding>
    (private val inflate: (LayoutInflater,ViewGroup,Boolean)-> Binding) : Fragment(){
    private var _binding: Binding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = container?.let { inflate.invoke(layoutInflater, it, false) }
        setupView()
        initVM()
        return _binding?.root
    }
    open fun setupView(){}
    open fun initVM(){}
    open fun checkInternet(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}