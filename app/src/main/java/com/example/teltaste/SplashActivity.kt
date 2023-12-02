package com.example.teltaste

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.teltaste.databinding.ActivityHomeBinding
import com.example.teltaste.interfaces.GetDataService
import com.example.teltaste.retrofitclient.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Response
import java.util.Locale
import java.util.Locale.Category
import javax.security.auth.callback.Callback

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, 3000)

    fun getCategoty() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object: retrofit2.Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                insertDataIntoRoomDb(response.body())
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    }

    private fun insertDataIntoRoomDb(category: List<Category>?) {

    }

}
