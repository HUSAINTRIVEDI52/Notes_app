package com.example.login_signup_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
import com.example.login_signup_firebase.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class ActivitySignUp : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //Initialize auth
        auth = FirebaseAuth.getInstance()
        binding.SignInSigup.setOnClickListener {
            startActivity(Intent(this, Login_Activity::class.java))
            finish()
        }
        binding.LoginBtnSignup.setOnClickListener {
            // Get text from edit text field
            val email = binding.EmailSignup.text.toString()
            val name = binding.NameSignUp.text.toString()
            val password = binding.passSignup.text.toString()
            val reppassword = binding.passRepeatSignup.text.toString()

            //check if any field is blank
            if (email.isEmpty() || name.isEmpty() || password.isEmpty() || reppassword.isEmpty()) {
                Toast.makeText(this, "Please Fill All The Details", Toast.LENGTH_SHORT).show()

            } else if (reppassword != password) {
                Toast.makeText(this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show()

            } else {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registration is Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, Login_Activity::class.java))
                            finish()


                        } else {
                            Toast.makeText(
                                this,
                                "Registration Failed Successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }
}
