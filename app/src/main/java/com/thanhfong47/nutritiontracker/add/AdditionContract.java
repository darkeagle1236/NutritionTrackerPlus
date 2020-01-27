package com.thanhfong47.nutritiontracker.add;

import android.content.Context;

import com.thanhfong47.nutritiontracker.exercise.Exercise;
import com.thanhfong47.nutritiontracker.food.Food;
import com.thanhfong47.nutritiontracker.user.User;

import java.util.List;

public interface AdditionContract {
    interface Model{

        interface FoodModel{
            int insertFood(Food food);
            void getFoodList(final OnFinishedListener onFinishedListener, String query);
            interface OnFinishedListener {
                void onFinished(List<Food> foodList);

                void onFailure(Throwable t);

                void onError(int errorCode);
            }
        }
        interface ExerciseModel{
            int insertExercise(Exercise exercise);
            void getExerciseList(final OnFinishedListener onFinishedListener, String query, User user);
            interface OnFinishedListener {
                void onFinished(List<Exercise> exerciseList);

                void onFailure(Throwable t);

                void onError(int errorCode);
            }
        }
    }
    interface View{
        Context getContext();
        void initAddButton(List<Exercise> exerciseList);
        void hideAddButton();
        void clearAllItem();
        String getQuery();
        void initUI();
        void setFoodDataToRecyclerView(List<Food> mfoodList);
        void setExerciseDataToRecyclerView(List<Exercise> mExerciseList);
        void showProgress();
        void hideProgress();
        void startMainActivity();
        void displayErrorMsg(String errMsg);
    }
    interface Presenter{
        interface FoodPresenter{
            void insertFoodToDb(List<Food> foodList);
            void onFinished(List<Food> foodList);
            void requestDataFromServer();
        }
        interface ExercisePresenter{
            void onFinished(List<Exercise> exerciseList);
            void insertExerciseToDb(List<Exercise> exerciseList);
            void requestDataFromServer();
            void onDeleteItem(List<Exercise> exerciseList);
        }
    }
}
