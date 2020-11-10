package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        RegisterListener()
    }

    private fun RegisterListener() {
        findViewById<MaterialButton>(R.id.btnRegisterSignup).setOnClickListener {
            val name = findViewById<TextInputEditText>(R.id.tietNameSignup).text.toString()
            val email = findViewById<TextInputEditText>(R.id.tietEmailSignup).text.toString()
            val password = findViewById<TextInputEditText>(R.id.tietPasswordSignup).text.toString()
            val passwordConfirmation =
                findViewById<TextInputEditText>(R.id.tietPasswordConfirmationSignup).text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty()) {
                val toast =
                    Toast.makeText(this, getString(R.string.avisoCampoVazio), Toast.LENGTH_SHORT)
                toast.show()
            } else if (password != passwordConfirmation) {
                val toast =
                    Toast.makeText(this, getString(R.string.avisoConfirmacao), Toast.LENGTH_SHORT)
                toast.show()
            } else {
                val intent = Intent(this, RestaurantesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}