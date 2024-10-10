package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity()  {
    companion object {
        var username = "Jihadan Beckhianosyuhada"
        var email = "jihadanbeckhianosyuhada@students.amikom.ac.id"
        var password = "jidan123"
        var bio = "Ingin menjadi Fullstack Developer"
        var display_name = "Jihadan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Input username dan password
        val usernameInput = findViewById<EditText>(R.id.username) // Mengambil referensi ke input field username dari layout
        val passwordInput = findViewById<EditText>(R.id.password) // Mengambil referensi ke input field password dari layout

        // Button Login
        val loginButton = findViewById<Button>(R.id.loginButton) // Mengambil referensi ke button login dari layout
        loginButton.setOnClickListener {
            // Mengambil nilai yang diinputkan oleh user dari EditText dan mengubahnya menjadi string
            val inputUser = usernameInput.text.toString() // Mengubah input username atau email ke string
            val inputPassword = passwordInput.text.toString() // Mengubah input password ke string

            // Validasi untuk username atau email dan password
            if ((inputUser == username || inputUser == email) && inputPassword == password) {
                // Jika valid, lanjutkan ke AccountActivity
                val intent = Intent(this, AccountActivity::class.java) // Membuat intent untuk berpindah ke activity lain (AccountActivity)
                startActivity(intent) // Memulai activity baru jika login berhasil
            } else {
                // Jika tidak valid, tampilkan pesan kesalahan
                // Menampilkan pesan error jika username/email atau password salah
                Toast.makeText(this, "Username/email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
