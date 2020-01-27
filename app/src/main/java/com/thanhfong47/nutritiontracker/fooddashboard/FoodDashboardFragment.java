package com.thanhfong47.nutritiontracker.fooddashboard;

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

import com.thanhfong47.nutritiontracker.R;
import com.thanhfong47.nutritiontracker.add.addfood.AddFoodActivity;
import com.thanhfong47.nutritiontracker.food.ParentFood;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FoodDashboardFragment extends Fragment implements FoodDashboardContract.View {
    Context context;
    RecyclerView rclvFood;
    ParentFoodDashboardAdapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<ParentFood> parentFoodList;
    FloatingActionButton fab;
    FoodDashboardContract.Presenter presenter;
    TextView tvCalories;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_food, container, false);
        context = getActivity();
        presenter = new FoodDashboardPresenterImpl(this);
        initUI(root);
        presenter.setDataToRecyclerView();
        tvCalories.setVisibility(presenter.isListEmpty(parentFoodList));
        return root;
    }

    @Override
    public void initUI(View view) {
        parentFoodList = new ArrayList<>();
        rclvFood = view.findViewById(R.id.rclvFood);
        adapter = new ParentFoodDashboardAdapter(view.getContext(), parentFoodList);
        mLayoutManager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        rclvFood.setLayoutManager(mLayoutManager);
        rclvFood.setItemAnimator(new DefaultItemAnimator());
        rclvFood.setAdapter(adapter);
        tvCalories = view.findViewById(R.id.tvCalories);
        fab = (FloatingActionButton)  view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(context, AddFoodActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setDataToRecyclerView(List<ParentFood> mfoodList) {
        parentFoodList.addAll(mfoodList);
        adapter.notifyDataSetChanged();
        rclvFood.setAdapter(adapter);
    }
    @Override
    public Context getContext(){
        return context;
    }
}