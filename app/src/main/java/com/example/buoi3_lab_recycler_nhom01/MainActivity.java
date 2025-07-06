package com.example.buoi3_lab_recycler_nhom01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_food;
    private FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recycler_food = findViewById(R.id.recycler_food);
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Phở", R.drawable.pho,"Phở bò truyền thống với nước dùng đậm đà.", 45000.0));
        foodList.add(new Food("Bún chả", R.drawable.buncha, "Bún chả Hà Nội thơm ngon, thịt nướng vàng ươm.", 40000.0));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi, "Bánh mì kẹp thịt, rau sống, nước sốt.", 20000.0));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam, "Cơm tấm sườn bì chả, trứng ốp la.", 50000.0));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon, "Gỏi cuốn tôm thịt, nước chấm đậm đà.", 30000.0));
        foodAdapter = new FoodAdapter(foodList);

        recycler_food.setLayoutManager(new LinearLayoutManager(this));
        recycler_food.setAdapter(foodAdapter);

        // Swipe to delete
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; // Không xử lý kéo thả
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                foodAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recycler_food);

        SharedPreferences sharedPreferences = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
        String lastFood = sharedPreferences.getString("lastFoodName", "Bạn chưa xem món ăn nào");
        TextView lastViewedTextView = findViewById(R.id.lastViewedTextView);
        lastViewedTextView.setText("Bạn vừa xem:" + lastFood);

        SharedPreferences sharedPreferences1 = getSharedPreferences("OrderedFood", MODE_PRIVATE);
        String OrderedFood = sharedPreferences1.getString("orderedFoodName", null);
        if (OrderedFood != null){
            Toast.makeText(this, "Bạn đã gọi món:" + OrderedFood, Toast.LENGTH_LONG).show();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}