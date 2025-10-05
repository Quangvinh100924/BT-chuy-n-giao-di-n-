package com.example.b4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tvAccount;
    ImageView ivSettings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvAccount = findViewById(R.id.etUsername);
        ivSettings = findViewById(R.id.ivSettings);

        // Nhận dữ liệu từ LoginActivity
        String username = getIntent().getStringExtra("USERNAME");
        tvAccount.setText("Logged in as: " + username);

        // Nút Setting để quay lại LoginActivity
        ivSettings.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            // Xóa ngăn xếp để không bị back quay lại Profile
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}