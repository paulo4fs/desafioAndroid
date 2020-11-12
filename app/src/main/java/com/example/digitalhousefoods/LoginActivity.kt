package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginListener()
        registerListener()
    }

    //  coloca no botão login o listener para erro e para fazer o login
    private fun loginListener() {
        var btnLogin = findViewById<MaterialButton>(R.id.btnLoginLogin)
        btnLogin.setOnClickListener {
            errorHandler()
            loginCheckEntry()
        }
    }

    //  verifica se existe ou não erro nos campos
    private fun errorHandler() {
        val emailText =
            findViewById<TextInputEditText>(R.id.tietEmailLogin)
        val emailLayout =
            findViewById<TextInputLayout>(R.id.tilEmailLogin)
        val passwordText =
            findViewById<TextInputEditText>(R.id.tietPasswordLogin)
        val passwordLayout =
            findViewById<TextInputLayout>(R.id.tilPasswordLogin)

        putError(emailText, emailLayout)
        clearError(emailText, emailLayout)
        putError(passwordText, passwordLayout)
        clearError(passwordText, passwordLayout)
    }

    //    Se o campo estiver vazio será marcado com erro
    private fun putError(textInput: TextInputEditText, textLayout: TextInputLayout) {
        if (textInput.text.toString().isEmpty()) {
            textLayout.isErrorEnabled = true
            textLayout.error = getString(R.string.avisoCampoVazio)
        }
    }

    //    Se o campo mudar o erro some
    private fun clearError(textInput: TextInputEditText, textLayout: TextInputLayout?) {
        textInput.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textLayout!!.isErrorEnabled = false
                textLayout.error = ""
            }
        })
    }

    private fun loginCheckEntry() {
        val email = findViewById<TextInputEditText>(R.id.tietEmailLogin).text.toString()
        val password = findViewById<TextInputEditText>(R.id.tietPasswordLogin).text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            val toast =
                Toast.makeText(this, getString(R.string.avisoCampoVazio), Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val intent = Intent(this, RestaurantesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerListener() {
        findViewById<MaterialButton>(R.id.btnRegisterLogin).setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
