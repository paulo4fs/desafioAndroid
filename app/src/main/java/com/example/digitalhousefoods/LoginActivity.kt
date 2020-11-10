package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        registerListener()
        loginListener()
    }

    private fun loginListener() {
        findViewById<MaterialButton>(R.id.btnLoginLogin).setOnClickListener {
            val email = findViewById<TextInputEditText>(R.id.tietEmailLogin).text.toString()
            val password = findViewById<TextInputEditText>(R.id.tietPasswordLogin).text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, RestaurantesActivity::class.java)
                startActivity(intent)
            }

            val toast = Toast.makeText(this, getString(R.string.avisoCampoVazio), Toast.LENGTH_SHORT)
            toast.show()

        }
    }


    private fun registerListener() {
        findViewById<MaterialButton>(R.id.btnRegisterLogin).setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}