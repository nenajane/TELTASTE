package com.example.teltaste.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingwithme.recipeapp.entities.Category
import com.codingwithme.recipeapp.entities.CategoryItems
import com.example.teltaste.dao.RecipeDao
import com.example.teltaste.entities.Recipes
import com.example.teltaste.entities.converter.CategoryListConverter


@Database(entities = [Recipes::class, CategoryItems::class, Category::class],version = 1,exportSchema = false)
@TypeConverters(CategoryListConverter::class)

abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase != null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}