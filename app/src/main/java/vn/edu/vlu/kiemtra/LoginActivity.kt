package vn.edu.vlu.kiemtra

import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Views mapped with traditional findViewById (no ViewBinding)
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { validate() }
    }

    private fun validate() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        val error: Int? = when {
            email.isEmpty() && password.isEmpty() -> R.string.err_both_empty
            email.isEmpty() -> R.string.err_email_empty
            password.isEmpty() -> R.string.err_password_empty
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> R.string.err_email_format
            password.length < 6 -> R.string.err_password_short
            else -> null
        }

        if (error != null) {
            showStatus(getString(error), isError = true)
            return
        }

        showStatus(getString(R.string.msg_success), isError = false)
    }

    private fun showStatus(message: String, isError: Boolean) {
        tvStatus.text = message
        tvStatus.setTextColor(if (isError) Color.parseColor("#C62828") else Color.parseColor("#2E7D32"))
    }
}
