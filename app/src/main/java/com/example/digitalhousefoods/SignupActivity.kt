package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        registerListener()
    }

    //  coloca no botão Registrar o listener para erro e para entrar no aplicativo
    private fun registerListener() {

        val btnSignup = findViewById<MaterialButton>(R.id.btnRegisterSignup)

        btnSignup.setOnClickListener {
            errorHandler()
            val name = findViewById<TextInputEditText>(R.id.tietNameSignup).text.toString()
            val email = findViewById<TextInputEditText>(R.id.tietEmailSignup).text.toString()
            val password = findViewById<TextInputEditText>(R.id.tietPasswordSignup).text.toString()
            val passwordConfirmation =
                findViewById<TextInputEditText>(R.id.tietPasswordConfirmationSignup).text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
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

    //  verifica se existe ou não erro nos campos
    private fun errorHandler() {
        val nameText =
            findViewById<TextInputEditText>(R.id.tietNameSignup)
        val nameLayout =
            findViewById<TextInputLayout>(R.id.tilNameSignup)
        val emailText =
            findViewById<TextInputEditText>(R.id.tietEmailSignup)
        val emailLayout =
            findViewById<TextInputLayout>(R.id.tilEmailSignup)
        val passwordText =
            findViewById<TextInputEditText>(R.id.tietPasswordSignup)
        val passwordLayout =
            findViewById<TextInputLayout>(R.id.tilPasswordSignup)
        val passwordConfirmationText =
            findViewById<TextInputEditText>(R.id.tietPasswordConfirmationSignup)
        val passwordConfirmationLayout =
            findViewById<TextInputLayout>(R.id.tilPasswordConfirmationSignup)

        putError(nameText, nameLayout)
        clearError(nameText, nameLayout)
        putError(emailText, emailLayout)
        clearError(emailText, emailLayout)
        putError(passwordText, passwordLayout)
        clearError(passwordText, passwordLayout)

//    Checa se a confirmação de password é igual ao password
        passwordConfirmationCheck(
            passwordText,
            passwordConfirmationText,
            passwordConfirmationLayout
        )
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

    private fun passwordConfirmationCheck(
        passwordText: TextInputEditText,
        passwordConfirmationText: TextInputEditText,
        passwodConfirmationLayout: TextInputLayout
    ) {
        if (passwordConfirmationText.text.toString() != passwordText.text.toString()) {
            passwodConfirmationLayout.isErrorEnabled = true
            passwodConfirmationLayout.error = getString(R.string.avisoConfirmacao)
        } else {
            passwodConfirmationLayout.isErrorEnabled = false
            passwodConfirmationLayout.error = ""
        }
    }
}
