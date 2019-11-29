package com.example.nutritiontracker.fooddashboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritiontracker.R;
import com.example.nutritiontracker.food.ParentFood;
import com.example.nutritiontracker.fooddetail.FoodDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ParentFoodDashboardAdapter extends RecyclerView.Adapter<ParentFoodDashboardAdapter.CustomViewHolder> {
    private List<ParentFood> parentFoodList;
    private Context context;
    private RecyclerView.RecycledViewPool viewPool;
    public ParentFoodDashboardAdapter(Context context, List<ParentFood> parentFoodList){
        this.context = context;
        this.parentFoodList = parentFoodList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView tvDate;
        RecyclerView rclvFood;
        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvDate = mView.findViewById(R.id.tvParentDate);
            rclvFood = mView.findViewById(R.id.rclvChildFood);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_parent_food, parent, false);
        viewPool = new RecyclerView.RecycledViewPool();
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        System.out.println(parentFoodList.get(holder.getAdapterPosition()).getDate());
        holder.tvDate.setText(parentFoodList.get(position).getDate());
        holder.rclvFood.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        holder.rclvFood.setAdapter(new FoodDashboardAdapter(context,parentFoodList.get(position).getFoodList()));
        holder.rclvFood.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentFoodList.size();
    }

}
