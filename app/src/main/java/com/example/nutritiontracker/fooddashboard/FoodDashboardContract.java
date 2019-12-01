package com.example.nutritiontracker.fooddashboard;

import android.content.Context;

import com.example.nutritiontracker.food.Food;
import com.example.nutritiontracker.food.ParentFood;

import java.util.List;

public interface FoodDashboardContract {
    interface Model{
        List<Food> getFoodListFromDb();
        List<Food> getFoodListFromDbByDate(String date);
        void deleteFood(Food food);
        List<ParentFood> getParentFoodList();
    }
    interface View{
        Context getContext();
        void initUI(android.view.View view);
        void setDataToRecyclerView(List<ParentFood> mfoodList);
    }
    interface Presenter{
        void setDataToRecyclerView();
        String getTotalCaloriesToday();
        int isListEmpty(List<ParentFood> mfoodList);
        int deleteFood(Food food);
    }
}
