package com.example.login_signup_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login_signup_firebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Activity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private lateinit  var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //initialize firebase auth

        auth=FirebaseAuth.getInstance()
        binding.signUpLogin.setOnClickListener{
            startActivity(Intent(this,ActivitySignUp::class.java))
            finish()

        }
        binding.LoginBtnLogin.setOnClickListener{
            val username=binding.EmailLogin.text.toString()
            val password=binding.passLogin.text.toString()

            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener{
                        task->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,MainActivity::class.java))
                        }else{
                            Toast.makeText(this, "Signed in failed ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }


    }
}