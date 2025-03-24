package com.example.fake_store.api

import com.example.fake_store.data.product.ResponseProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<List<ResponseProductItem>>

    @GET("products/{id}")
    suspend fun getProductsById(
      @Path("id")  id:Int
    ): Response<ResponseProductItem>
}