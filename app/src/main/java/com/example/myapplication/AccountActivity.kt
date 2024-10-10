package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.account)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menampilkan data dari LoginActivity
        val username = LoginActivity.username
        val email = LoginActivity.email
        val password = LoginActivity.password
        val bio = LoginActivity.bio
        val displayName = LoginActivity.display_name

        // Set TextView untuk menampilkan data
        findViewById<TextView>(R.id.edit_username).text = "$username"
        findViewById<TextView>(R.id.edit_email).text = "$email"
        findViewById<TextView>(R.id.edit_password).text = "$password"
        findViewById<TextView>(R.id.edit_bio).text = "$bio"
        findViewById<TextView>(R.id.edit_display_name).text = "$displayName"

        // Mengatur OnClickListener untuk "Call Us"
        findViewById<TextView>(R.id.call_us).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:081234567811")
            }
            startActivity(intent)
        }

        // Mengatur OnClickListener untuk "Website"
        findViewById<TextView>(R.id.website).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://si.amikom.ac.id/")
            }
            startActivity(intent)
        }

        // Mengatur OnClickListener untuk "Maps"
        findViewById<TextView>(R.id.maps).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("geo:0,0?q=Universitas+Amikom+Yogyakarta")
            }
            startActivity(intent)
        }
    }
}
