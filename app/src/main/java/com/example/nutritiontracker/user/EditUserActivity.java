package com.example.nutritiontracker.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.nutritiontracker.R;

import java.util.ArrayList;

public class EditUserActivity extends AppCompatActivity implements UserContract.View {
    EditText edtName,edtWeight,edtHeight,edtAge;
    Spinner spnGender;
    Button btnSubmit;
    UserContract.Presenter iPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        iPresenter = new UserPresenterImpl(this);
        initSpinner();
        initUI();
    }
    public void initUI(){
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        spnGender = findViewById(R.id.spnGender);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUsername(edtName.getText().toString());
                user.setAge(edtAge.getText().toString());
                user.setGender(spnGender.getSelectedItem().toString());
                user.setWeight(edtWeight.getText().toString());
                user.setHeight(edtHeight.getText().toString());
                iPresenter.changeUserInfo(user);
                startMainActivity();
            }
        });
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

    @Override
    public User getUserInfo() {
        return null;
    }

    @Override
    public void startCreateUserActivity() {

    }

    @Override
    public void startMainActivity() {
        finish();
    }
}
