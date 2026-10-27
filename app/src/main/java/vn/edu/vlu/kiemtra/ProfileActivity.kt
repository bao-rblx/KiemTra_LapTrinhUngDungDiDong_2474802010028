package vn.edu.vlu.kiemtra

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }

    // Views mapped with traditional findViewById (no ViewBinding)
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // Extract the email sent from LoginActivity via putExtra()
        val email = intent.getStringExtra(EXTRA_EMAIL).orEmpty()
        tvEmail.text = getString(R.string.profile_email, email)

        // Log Out: close this screen and return to LoginActivity
        btnLogout.setOnClickListener { finish() }
    }
}
