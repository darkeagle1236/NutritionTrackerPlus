package com.thanhfong47.nutritiontracker.fooddashboard;

import com.thanhfong47.nutritiontracker.food.Food;
import com.thanhfong47.nutritiontracker.food.FoodModel;
import com.thanhfong47.nutritiontracker.food.ParentFood;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class FoodDashboardPresenterImpl implements FoodDashboardContract.Presenter {
    private FoodDashboardContract.View iView;
    private FoodDashboardContract.Model iModel;
    public FoodDashboardPresenterImpl(FoodDashboardContract.View iView) {
        this.iView = iView;
        iModel = new FoodModel(iView.getContext());
    }

    @Override
    public void setDataToRecyclerView() {
        iView.setDataToRecyclerView(iModel.getParentFoodList());
    }

    @Override
    public String getTotalCaloriesToday() {
        double totalCalories = 0;
        for(Food food : iModel.getFoodListFromDb()){
            totalCalories += food.getNfCalories();
        }
        NumberFormat formatter = new DecimalFormat("#0.00");
        return "Total calories burned today : "+formatter.format(totalCalories)+"";
    }

    @Override
    public int isListEmpty(List<ParentFood> mfoodList) {
        return mfoodList.isEmpty() ? 0 : 8;
    }

    @Override
    public int deleteFood(Food food) {
        iModel.deleteFood(food);
        return 0;
    }
}
