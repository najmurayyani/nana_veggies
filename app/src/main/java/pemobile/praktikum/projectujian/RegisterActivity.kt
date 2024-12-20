package pemobile.praktikum.projectujian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnCreateAccount: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etConfirmPassword = findViewById(R.id.et_confirm_password)
        btnCreateAccount = findViewById(R.id.btn_create_account)
        tvLogin = findViewById(R.id.tv_login)

        btnCreateAccount.setOnClickListener {
            handleCreateAccount()
        }

        tvLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleCreateAccount() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val confirmPassword = etConfirmPassword.text.toString().trim()

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Password is mismatch", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun handleLogin() {
        finish()
    }
}
