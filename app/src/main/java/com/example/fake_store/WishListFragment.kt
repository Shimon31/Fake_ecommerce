package com.example.fake_store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fake_store.base.baseFragment
import com.example.fake_store.databinding.FragmentWishListBinding


class WishListFragment : baseFragment<FragmentWishListBinding>(FragmentWishListBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}