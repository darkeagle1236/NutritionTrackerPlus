package com.thanhfong47.nutritiontracker.exercise;

import java.util.List;

public class ExerciseDashboardPresenterImpl implements ExerciseDashboardContract.Presenter {
    private ExerciseDashboardContract.View iView;
    private ExerciseDashboardContract.Model iModel;
    public ExerciseDashboardPresenterImpl(ExerciseDashboardContract.View iView) {
        this.iView = iView;
        iModel = new ExerciseModel(iView.getContext());
    }

    @Override
    public void setDataToRecyclerView() {
        List<ParentExercise> parentExerciseList = iModel.getParentExerciseList();
        iView.setDataToRecyclerView(parentExerciseList);
    }


    @Override
    public String getTotalCaloriesBurnedToday() {
//        double totalCaloriesBurned = 0;
//        for(Exercise exercise : iModel.getExerciseListFromDb()){
//            totalCaloriesBurned += exercise.getNfCalories();
//        }
//        NumberFormat formatter = new DecimalFormat("#0.00");
//        return "Total calories burned today : "+formatter.format(totalCaloriesBurned)+"";
        return "test";
    }

    @Override
    public int isListEmpty(List<ParentExercise> parentExerciseList) {
        return parentExerciseList.isEmpty() ? 0 : 8;
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        iModel.deleteExercise(exercise);
    }

}
