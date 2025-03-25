package com.example.fake_store.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.load
import com.example.fake_store.R
import com.example.fake_store.base.baseFragment
import com.example.fake_store.databinding.FragmentDetailsBinding
import com.example.fake_store.ui.home.HomeViewModel
import kotlinx.coroutines.launch

class DetailsFragment : baseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {

    val viewmodel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.productResponse.observe(viewLifecycleOwner) {

            binding.apply {
                productImage.load(it.image)
                productName.text = it.title
                productsOfferPrice.text = "$ ${it.price}"
                productDescription.text = it.description
                categoryTV.text = it.category
                ratingTV.text = "${it.rating.rate}"
                ratingTotalTV.text = "(${it.rating.count})"
            }

        }
    }

}