package com.thanhfong47.nutritiontracker.add.addexercise;

import com.thanhfong47.nutritiontracker.add.AdditionContract;
import com.thanhfong47.nutritiontracker.exercise.Exercise;
import com.thanhfong47.nutritiontracker.exercise.ExerciseModel;
import com.thanhfong47.nutritiontracker.user.UserContract;
import com.thanhfong47.nutritiontracker.user.UserModel;

import java.util.List;

public class AddExercisePresenterImpl implements AdditionContract.Presenter.ExercisePresenter, AdditionContract.Model.ExerciseModel.OnFinishedListener {
    AdditionContract.View iView;
    AdditionContract.Model.ExerciseModel iExerciseModel;
    UserContract.Model iUserModel;
    public AddExercisePresenterImpl(AdditionContract.View iView) {
        this.iView = iView;
        iExerciseModel = new ExerciseModel(iView.getContext());
        iUserModel = new UserModel(iView);
    }


    @Override
    public void onFinished(List<Exercise> exerciseList) {
        iView.clearAllItem();
        iView.setExerciseDataToRecyclerView(exerciseList);
        iView.hideProgress();
    }

    @Override
    public void insertExerciseToDb(List<Exercise> exerciseList) {
        for(Exercise exercise : exerciseList){
            iExerciseModel.insertExercise(exercise);
        }
        iView.startMainActivity();
    }

    @Override
    public void requestDataFromServer() {
        iView.showProgress();
        iExerciseModel.getExerciseList(this,iView.getQuery(),iUserModel.getAllUser().get(0));
    }

    @Override
    public void onDeleteItem(List<Exercise> exerciseList) {
        if (exerciseList.isEmpty()){
            iView.hideAddButton();
        }
        else{
            iView.initAddButton(exerciseList);
        }
    }

    @Override
    public void onFailure(Throwable t) {
        iView.displayErrorMsg(t.getMessage());
        iView.hideProgress();
    }

    @Override
    public void onError(int errorCode) {
        if(errorCode==404){
            iView.displayErrorMsg("Not found your exercise. Please try again !");
        }
        else if(errorCode == 400){
            iView.displayErrorMsg("Bad request. Check your internet connection");
        }
        else {
            iView.displayErrorMsg("Unknown error. Restarting the app may helps");
        }
        iView.hideProgress();
    }
}
