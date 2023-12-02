package com.example.teltaste

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.teltaste.databinding.ActivityHomeBinding
import com.example.teltaste.interfaces.GetDataService
import com.example.teltaste.retrofitclient.RetrofitClientInstance
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Response
import java.util.Locale
import java.util.Locale.Category
import javax.security.auth.callback.Callback




class SplashActivity : BaseActivity(), EasyPermissions.RationaleCallbacks, EasyPermissions.PermissionCallbacks {
    private var READ_STORAGE_PERM = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, 3000)

        fun getCategoty() {
            val service =
                RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
            val call = service.getCategoryList()
            call.enqueue(object : Callback<Category>,
                retrofit2.Callback<com.example.teltaste.entities.Category> {
                override fun onResponse(
                    call: Call<com.example.teltaste.entities.Category>,
                    response: Response<com.example.teltaste.entities.Category>
                ) {
                    for (arr in response.body()!!.categorieitems!!) {
                        getMeal(arr.strcategory)
                    }

                }

                override fun onFailure(
                    call: Call<com.example.teltaste.entities.Category>,
                    t: Throwable
                ) {
                    Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                        .show()
                }


            })

        }
    }
}

