package com.example.nutritiontracker.exercise;

import android.content.Context;

import com.example.nutritiontracker.food.Food;

import java.util.List;

public interface ExerciseDashboardContract {
    interface Model{
        List<Exercise> getExerciseListFromDb();
        List<Exercise> getExerciseListFromDbByDate(String date);
        List<ParentExercise> getParentExerciseList();
    }
    interface View{
        Context getContext();
        void initUI(android.view.View view);
        void setDataToRecyclerView(List<ParentExercise> parentExerciseList);
    }
    interface Presenter{
        void setDataToRecyclerView();
        String getTotalCaloriesBurnedToday();
        int isListEmpty(List<ParentExercise> parentExerciseList);
    }
}
