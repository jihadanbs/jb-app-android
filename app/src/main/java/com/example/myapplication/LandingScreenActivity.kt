package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class LandingScreenActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_landing_screen)

        // Mengatur padding untuk mengakomodasi system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.landing_screen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan listener untuk tombol Log In
        val loginButton: Button = findViewById(R.id.btn_log_in)
        loginButton.setOnClickListener {
            // Membuka LoginActivity menggunakan Intent eksplisit
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}