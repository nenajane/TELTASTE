package com.example.teltaste.interfaces

import com.example.teltaste.entities.Category
import retrofit2.Call
import retrofit2.http.GET
import java.util.Locale

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>
}