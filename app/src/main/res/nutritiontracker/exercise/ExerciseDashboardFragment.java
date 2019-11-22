package com.example.nutritiontracker.exercise;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nutritiontracker.R;
import com.example.nutritiontracker.add.addexercise.AddExcerciseActivity;
import com.example.nutritiontracker.add.addfood.AddFoodActivity;
import com.example.nutritiontracker.fooddashboard.FoodDashboardAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDashboardFragment extends Fragment implements ExerciseDashboardContract.View {
    Context context;
    RecyclerView rclvExercise;
    ExerciseDashboardAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<Exercise> exerciseList;
    TextView tvCalories;;
    FloatingActionButton fab;
    ExerciseDashboardContract.Presenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        context = getActivity();
        presenter = new ExerciseDashboardPresenterImpl(this);
        initUI(root);
        presenter.setDataToRecyclerView();
        tvCalories.setText(presenter.getTextMessage(exerciseList));
        return root;
    }

    @Override
    public void initUI(android.view.View view) {
        exerciseList = new ArrayList<>();
        rclvExercise = view.findViewById(R.id.rclvExercises);
        adapter = new ExerciseDashboardAdapter(view.getContext(), exerciseList);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        rclvExercise.setLayoutManager(mLayoutManager);
        rclvExercise.setItemAnimator(new DefaultItemAnimator());
        rclvExercise.setAdapter(adapter);
        tvCalories = view.findViewById(R.id.tvCalories);fab = (FloatingActionButton)  view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(context, AddExcerciseActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setDataToRecyclerView(List<Exercise> mExerciseList) {
        exerciseList.addAll(mExerciseList);
        adapter.notifyDataSetChanged();
        rclvExercise.setAdapter(adapter);
    }
}