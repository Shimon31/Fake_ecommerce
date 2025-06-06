package com.example.fake_store.repos

import android.util.Log
import com.example.fake_store.api.ProductService
import com.example.fake_store.data.product.ResponseProductItem
import retrofit2.Response
import javax.inject.Inject

class GetProductsRepo @Inject constructor(private val service: ProductService) {

    suspend fun getAllProducts() : Response<List<ResponseProductItem>>{
        return service.getAllProducts()
    }

    suspend fun getProductById(id:Int):Response<ResponseProductItem>{

        val data = service.getProductsById(id)
        Log.d("TAG", "getProductById: ${data.body()}")
        return service.getProductsById(id)
    }

}