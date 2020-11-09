package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        RegisterListener()
        LoginListener()
    }

    private fun LoginListener() {
        findViewById<MaterialButton>(R.id.btnLoginLogin).setOnClickListener {
//            val email = findViewById<TextInputEditText>(R.id.tietEmailLogin).text.toString()
//            val password = findViewById<TextInputEditText>(R.id.tietPasswordLogin).text.toString()
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                val intent = Intent(this, ActivityRestaurantes::class.java)
//                startActivity(intent)
//            }
            val intent = Intent(this, RestaurantesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun RegisterListener() {
        findViewById<MaterialButton>(R.id.btnRegisterLogin).setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}