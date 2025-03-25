package com.example.fake_store.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fake_store.data.product.ResponseProductItem
import com.example.fake_store.repos.GetProductsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: GetProductsRepo) : ViewModel() {

    var _allProductResponse = MutableLiveData<List<ResponseProductItem>>()
    val allProductResponse: LiveData<List<ResponseProductItem>>
        get() = _allProductResponse


    init {
        getAllProducts()
    }

    private fun getAllProducts() {

        viewModelScope.launch {

            val response = repo.getAllProducts()

            if (response.isSuccessful) {
                _allProductResponse.postValue(response.body())
            }

        }

    }

    var _productResponse = MutableLiveData<ResponseProductItem>()
    val productResponse: LiveData<ResponseProductItem>
        get() = _productResponse

     fun getProductById(id: Int) {
        viewModelScope.launch {
            val response = repo.getProductById(20)
            Log.d("TAG", "getProductById: ${response.body()}")
            if (response.isSuccessful) {
                _productResponse.postValue(response.body())
            }
        }

    }

}