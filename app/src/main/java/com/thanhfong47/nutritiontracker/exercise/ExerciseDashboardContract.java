package com.thanhfong47.nutritiontracker.exercise;

import android.content.Context;

import java.util.List;

public interface ExerciseDashboardContract {
    interface Model{
        List<Exercise> getExerciseListFromDb();
        List<Exercise> getExerciseListFromDbByDate(String date);
        List<ParentExercise> getParentExerciseList();
        void deleteExercise(Exercise exercise);
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
        void deleteExercise(Exercise exercise);
    }
}
