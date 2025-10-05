package com.example.selt_design;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// Nguyen Quang Vinh - 22115141122127
public class MainActivity extends AppCompatActivity {

    private EditText weightInput, heightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ cân nặng và chiều cao", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        double bmi = weight / (height * height);
        String category = classifyBMI(bmi);

        resultText.setText(String.format("Chỉ số BMI: %.2f\nPhân loại: %s", bmi, category));
    }

    private String classifyBMI(double bmi) {
        if (bmi < 18) {
            return "Người gầy";
        } else if (bmi >= 18 && bmi <= 24.9) {
            return "Người bình thường";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Người béo phì độ I";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Người béo phì độ II";
        } else { // bmi >= 35
            return "Người béo phì độ III";
        }
    }
}