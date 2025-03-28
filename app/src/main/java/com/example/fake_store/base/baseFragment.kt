package com.example.fake_store.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class baseFragment <VB : ViewBinding>(

    private val bindingInflater : (inflater : LayoutInflater) -> VB

) : Fragment() {

    private var _binding : VB? = null

    val binding : VB
        get() =   _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = bindingInflater.invoke(layoutInflater)
        return binding.root


    }

}