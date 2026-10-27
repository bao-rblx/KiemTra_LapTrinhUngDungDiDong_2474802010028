package vn.edu.vlu.kiemtra

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }

    // Views mapped with traditional findViewById (no ViewBinding)
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    // Sample data: at least 05 subjects/skills
    private val subjects = arrayOf(
        "Kotlin Programming",
        "XML Layout Design",
        "Git/GitHub Management",
        "Intent Processing",
        "Android Architecture"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // Extract the email sent from LoginActivity via putExtra()
        val email = intent.getStringExtra(EXTRA_EMAIL).orEmpty()
        tvEmail.text = getString(R.string.profile_email, email)

        // Log Out: close this screen and return to LoginActivity
        btnLogout.setOnClickListener { finish() }

        // Attach ArrayAdapter with the built-in android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        // Item click: show a Toast with the exact name of the selected subject
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val selected = subjects[position]
            Toast.makeText(this, getString(R.string.toast_selected, selected), Toast.LENGTH_SHORT).show()
        }
    }
}
