package com.example.nutritiontracker.exercise;

import java.util.List;

public class ParentExercise {
    private String date;
    private List<Exercise> exerciseList;

    public ParentExercise() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
