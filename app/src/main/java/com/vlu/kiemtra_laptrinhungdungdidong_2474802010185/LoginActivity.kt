package com.vlu.kiemtra_laptrinhungdungdidong_2474802010185
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bắt buộc dùng findViewById, không dùng ViewBinding
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                email.isEmpty() || password.isEmpty() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.setText(R.string.error_empty_input)
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.setText(R.string.error_invalid_email)
                }
                password.length < 6 -> {
                    tvStatus.setTextColor(Color.RED)
                    tvStatus.setText(R.string.error_short_password)
                }
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                    tvStatus.text = "Xác thực thành công!"

                    // 2.3 & 2.4: Khởi tạo Explicit Intent truyền Bundle Email sang ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        putExtra("EXTRA_USER_EMAIL", email)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}