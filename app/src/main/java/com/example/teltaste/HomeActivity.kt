package com.example.teltaste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teltaste.adapter.MainCategoryAdapter
import com.example.teltaste.adapter.SubCategoryAdapter
import com.example.teltaste.entities.Recipes

class HomeActivity : AppCompatActivity() {

    var arrMainCategory = ArrayList<Recipes>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    var rvMainCategory: RecyclerView? = null
    var rvSubCategory: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        rvMainCategory = findViewById(R.id.rv_main_category)
        rvSubCategory = findViewById(R.id.rv_sub_category)

        //data of dishes
        arrMainCategory.add(Recipes(1, "Pork"))
        arrMainCategory.add(Recipes(2, "Beef"))
        arrMainCategory.add(Recipes(3, "Chicken"))
        arrMainCategory.add(Recipes(4, "Desert"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipes(1, "Desert"))
        arrSubCategory.add(Recipes(2, "Salad"))
        arrSubCategory.add(Recipes(3, "Graham"))
        arrSubCategory.add(Recipes(4, "Cookies"))

        subCategoryAdapter.setData(arrSubCategory)

        rvMainCategory?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvMainCategory?.adapter = mainCategoryAdapter

        rvSubCategory?.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvSubCategory?.adapter = subCategoryAdapter


    }
    }
