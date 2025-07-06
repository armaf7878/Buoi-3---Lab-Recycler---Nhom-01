package com.example.buoi3_lab_recycler_nhom01;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView food_img;
        TextView food_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            food_img = itemView.findViewById(R.id.food_img);
            food_name = itemView.findViewById(R.id.food_name);
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(v.getContext(), "Bạn chọn: " + foodList.get(position).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.food_img.setImageResource(food.getImg_resID());
        holder.food_name.setText(food.getName());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
//            intent.putExtra("foodName", food.getName()); //Buổi 4 - Lab 1
//            intent.putExtra("foodImage", food.getImg_resID()); //Buổi 4 - Lab 1
//            intent.putExtra("foodDescription", food.getDescription()); //Buổi 4 - Lab 1
//            intent.putExtra("foodPrice", food.getPrice()); //Buổi 4 - Lab 1
            intent.putExtra("foodItem", food);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void removeItem(int position){
        foodList.remove(position);
        notifyItemRemoved(position);
    }


}
