package com.thanhfong47.nutritiontracker.fooddetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.thanhfong47.nutritiontracker.R;
import com.squareup.picasso.Picasso;

public class FoodDetailActivity extends AppCompatActivity {
    Intent intent;
    ImageView ivIcon;
    TextView tvName,tvCalories,tvQuantity,tvUnit,tvWeight
            ,tvTotalFat,tvSaturatedFat,tvChoresterol,tvSodium
            ,tvTotalCarbonhydrate,tvDietaryFiber,tvSugars,tvProtein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        initUI();
        intent = getIntent();
        if(intent.hasExtra("bundle")){
            Bundle bundle = intent.getBundleExtra("bundle");
                if(bundle.containsKey("foodname")){
                    Log.e("Activity2 Log", "foodname : "+bundle.getString("foodname"));
                }

            Picasso.get()
                    .load(bundle.getString("imageurl"))
                    .into(ivIcon);
            tvName.setText(bundle.getString("foodname"));
            tvCalories.setText("Calories : "+bundle.getString("calories"));
            tvQuantity.setText("Quantity : "+bundle.getString("quantity"));
            tvUnit.setText("Unit : "+bundle.getString("unit"));
            tvWeight.setText("Weight : "+bundle.getString("weight")+" g");
            tvChoresterol.setText("Choresterol : "+ bundle.getString("choresterol")+" mg");
            tvDietaryFiber.setText("Dietary Fiber : "+bundle.getString("dietaryfiber")+"mg");
            tvTotalFat.setText("Total fat "+bundle.getString("totalfat")+" g");
            tvSaturatedFat.setText("Saturated fat "+bundle.getString("saturatedfat")+" mg");
            tvSugars.setText("Sugars : "+bundle.getString("sugars")+" g");
            tvProtein.setText("Protein : "+bundle.getString("protein")+" g");
            tvSodium.setText("Sodium : "+bundle.getString("sodium")+" g");
            tvTotalCarbonhydrate.setText("Total carbonhydrate : "+bundle.getString("totalcarbonhydrate")+" mg");
        }
    }
    private void initUI() {
        ivIcon = findViewById(R.id.ivIcon);
        tvName = findViewById(R.id.tvName);
        tvCalories = findViewById(R.id.tvCalories);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvUnit = findViewById(R.id.tvUnit);
        tvWeight = findViewById(R.id.tvWeight);
        tvTotalCarbonhydrate = findViewById(R.id.tvTotalCarbonhydrate);
        tvTotalFat = findViewById(R.id.tvTotalFat);
        tvSaturatedFat = findViewById(R.id.tvSaturatedFat);
        tvChoresterol = findViewById(R.id.tvChoresterol);
        tvSodium = findViewById(R.id.tvSodium);
        tvDietaryFiber = findViewById(R.id.tvDietaryFiber);
        tvSugars = findViewById(R.id.tvSugars);
        tvProtein = findViewById(R.id.tvProtein);
    }
}
