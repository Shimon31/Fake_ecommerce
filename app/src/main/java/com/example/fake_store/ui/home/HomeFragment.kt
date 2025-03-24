package com.example.fake_store.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fake_store.R
import com.example.fake_store.base.baseFragment
import com.example.fake_store.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : baseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),HomeAdapter.Listener {

   val viewModel : HomeViewModel by activityViewModels()
    val adapter : HomeAdapter by  lazy {

        HomeAdapter(this@HomeFragment)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner){

            adapter.submitList(it)
            binding.recyclerView1.adapter = adapter


        }
    }

    override fun itemClick(id: Int) {
        viewModel.getProductById(id)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment2)
    }


}