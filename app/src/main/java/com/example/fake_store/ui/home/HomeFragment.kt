package com.example.fake_store.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fake_store.R
import com.example.fake_store.base.baseFragment
import com.example.fake_store.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : baseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),HomeAdapter.Listener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeAdapter(this)
        binding.recyclerView1.adapter = adapter

        viewModel.allProductResponse.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.productResponse.observe(viewLifecycleOwner) { product ->
            // Navigate to details screen or show in UI
            Toast.makeText(requireContext(), "Product: ${product.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun itemClick(id: Int) {
        Log.d("TAG", "Clicked item ID: $id")
        viewModel.getProductById(id) // ✅ This ensures you call with correct ID
    }

}