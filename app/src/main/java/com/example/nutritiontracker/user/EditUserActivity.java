package com.example.nutritiontracker.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.nutritiontracker.R;

import java.util.ArrayList;

public class EditUserActivity extends AppCompatActivity {
    Spinner spnGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        initSpinner();
    }

    public void initSpinner() {
        spnGender = findViewById(R.id.spnGender);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("male");
        arrayList.add("female");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGender.setAdapter(arrayAdapter);
    }
}
