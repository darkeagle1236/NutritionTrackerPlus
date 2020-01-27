package com.thanhfong47.nutritiontracker.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thanhfong47.nutritiontracker.user.EditUserActivity;
import com.thanhfong47.nutritiontracker.R;

public class SettingsFragment extends Fragment {
    TextView tvEdit,tvExit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_setting, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        tvEdit = view.findViewById(R.id.tvEdit);
        tvExit = view.findViewById(R.id.tvExit);
        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditUserActivity.class);
                startActivity(intent);
            }
        });
        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}