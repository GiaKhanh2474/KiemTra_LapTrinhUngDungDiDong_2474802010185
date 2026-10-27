package com.vlu.kiemtra_laptrinhungdungdidong_2474802010185

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSkills = findViewById<ListView>(R.id.lvSkills)

        val email = intent.getStringExtra("EXTRA_USER_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = "Email: $email"

        btnLogout.setOnClickListener {
            finish()
        }

        // 3.3. Dữ liệu mảng gồm 5 môn học / kỹ năng
        val skillList = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 3.4. Gắn ArrayAdapter sử dụng layout mẫu simple_list_item_1
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skillList
        )
        lvSkills.adapter = adapter

        // 3.5. Bắt sự kiện Click item hiển thị Toast
        lvSkills.setOnItemClickListener { _, _, position, _ ->
            val selectedSkill = skillList[position]
            Toast.makeText(this, "Bạn đã chọn: $selectedSkill", Toast.LENGTH_SHORT).show()
        }
    }
}