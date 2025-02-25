package com.example.login_signup_firebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login_signup_firebase.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.LoginMain.setOnClickListener{
            startActivity(Intent(this,Login_Activity::class.java))
            finish()
        }
        binding.SignUpMain.setOnClickListener{
            startActivity(Intent(this,ActivitySignUp::class.java))
        }

    }
}