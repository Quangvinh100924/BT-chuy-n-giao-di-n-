package com.example.vidu1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Thiết lập giao diện lấy từ file main.xml
            setContentView(R.layout.activity_main);
            // Lấy về các thành phần trong main.xml thông qua id
            final EditText edit = (EditText) findViewById(R.id.edit_text);
            final TextView text = (TextView) findViewById(R.id.text_view);
            // Thiết lập xử lý cho sự kiện nhấn nút giữa của điện thoại
            edit.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if( keyCode == KeyEvent.KEYCODE_ENTER ) {
                        if (event.getAction() == KeyEvent.ACTION_UP) {
                            text.setText(edit.getText().toString());
                            edit.setText("");
                        }
                        return true;
                    }
                    return false;
                }
            });
        }
    }