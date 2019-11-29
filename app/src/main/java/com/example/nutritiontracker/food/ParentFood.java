package com.example.nutritiontracker.food;

import java.util.List;

public class ParentFood {
    private String date;
    private List<Food> foodList;

    public ParentFood() {
    }

    public ParentFood(String date, List<Food> foodList) {
        this.date = date;
        this.foodList = foodList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
