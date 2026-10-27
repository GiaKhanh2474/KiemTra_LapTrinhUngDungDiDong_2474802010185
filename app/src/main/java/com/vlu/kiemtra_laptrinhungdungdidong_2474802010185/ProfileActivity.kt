package com.vlu.kiemtra_laptrinhungdungdidong_2474802010185

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 2.2 Ánh xạ View bằng findViewById
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // 2.4 Trích xuất dữ liệu Email truyền qua Intent và hiển thị lên TextView
        val email = intent.getStringExtra("EXTRA_USER_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = "Email: $email"

        // 2.5 Bắt sự kiện click nút Đăng xuất: đóng màn hình quay về Login
        btnLogout.setOnClickListener {
            finish()
        }
    }
}