package com.example.buoi3_lab_recycler_nhom01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    private TextView detailTextView;
    private ImageView detailImageView;
    private Button orderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        detailTextView = findViewById(R.id.detailTextView);
        detailImageView = findViewById(R.id.detailImageView);

//        String foodName = getIntent().getStringExtra("foodName"); //Buổi 4 - Lab1
//        int foodImg = getIntent().getIntExtra("foodImage", 0); //Buổi 4 - Lab1
//        String foodDescription = getIntent().getStringExtra("foodDescription"); //Buổi 4 - Lab1
//        Double foodPrice = getIntent().getDoubleExtra("foodPrice", 0); //Buổi 4 - Lab1

        Food food = getIntent().getParcelableExtra("foodItem");

//        String detailText = "Tên món ăn:" + foodName + "\nMô tả:" + foodDescription + "\nGía:" + foodPrice + "VND"; //Buổi 4 - Lab1
        String detailText = "Tên món ăn:" + food.getName() + "\nMô tả:" + food.getDescription() + "\nGía:" + food.getPrice() + "VND";
        detailTextView.setText(detailText);
        detailImageView.setImageResource(food.getImg_resID());

        orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(view -> {
            Toast.makeText(this, "Bạn đã gọi món thành công", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences1 = getSharedPreferences("OrderedFood", MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
            editor1.putString("orderedFoodName", food.getName());
            editor1.apply();
        });

        //Buổi 4 - Lab 3 SHAREREFERENCES
        SharedPreferences preferences = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lastFoodName", food.getName());
        editor.apply();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}