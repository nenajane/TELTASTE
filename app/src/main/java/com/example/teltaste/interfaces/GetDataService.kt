package com.example.teltaste.interfaces

import retrofit2.Call
import retrofit2.http.GET
import java.util.Locale

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<List<Locale.Category>>
}