package com.example.fake_store

import com.example.fake_store.repos.GetProductsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewHolder @Inject constructor(val repo: GetProductsRepo) {

fun getAllProducts(){


}

}