package com.example.teltaste

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.teltaste.interfaces.GetDataService
import com.example.teltaste.retrofitclient.RetrofitClientInstance
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
    }
}
