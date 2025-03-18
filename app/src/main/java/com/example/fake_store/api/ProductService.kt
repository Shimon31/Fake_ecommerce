package com.example.fake_store.api

import com.example.fake_store.data.product.ResponseProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<List<ResponseProductItem>>

    @GET("products")
    suspend fun getProductsById(): Response<ResponseProductItem>
}