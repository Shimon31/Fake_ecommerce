package com.example.fake_store.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.fake_store.base.baseFragment
import com.example.fake_store.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : baseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

   val viewModel : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner){

            it.forEach { p->

                Log.d("TAG", "onViewCreated: ${p.title}")
            }

        }
    }


}