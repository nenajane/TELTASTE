package com.example.teltaste.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teltaste.entities.Category
import com.example.teltaste.entities.Recipes


@Dao
interface RecipeDao {

    @get:Query("SELECT * FROM category ORDER BY id DESC")
    val getAllCategory: List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Query("DELETE FROM categoryitems")
    suspend fun clearDb()
}