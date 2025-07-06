package com.example.buoi3_lab_recycler_nhom01;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    private TextView detailTextView;
    private ImageView detailImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        detailTextView = findViewById(R.id.detailTextView);
        detailImageView = findViewById(R.id.detailImageView);

        String foodName = getIntent().getStringExtra("foodName");
        int foodImg = getIntent().getIntExtra("foodImage", 0);
        String foodDescription = getIntent().getStringExtra("foodDescription");
        Double foodPrice = getIntent().getDoubleExtra("foodPrice", 0);

        String detailText = "Tên món ăn:" + foodName + "\nMô tả:" + foodDescription + "\nGía:" + foodPrice + "VND";

        detailTextView.setText(detailText);
        detailImageView.setImageResource(foodImg);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}