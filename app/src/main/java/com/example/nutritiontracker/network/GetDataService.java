package com.example.nutritiontracker.network;


import com.example.nutritiontracker.exercise.ExerciseResponse;
import com.example.nutritiontracker.food.FoodListResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetDataService {

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "x-app-id: 1f12ff90",
            "x-app-key: 828e7ed748772851e3efd486ae254efa"
    })
    @FormUrlEncoded
    @POST("v2/natural/nutrients")
    Call<FoodListResponse> getFoodList(@Field("query") String query);

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "x-app-id: 1f12ff90",
            "x-app-key: 828e7ed748772851e3efd486ae254efa"
    })
    @FormUrlEncoded
    @POST("v2/natural/exercise")
    Call<ExerciseResponse> getExerciseList(@Field("query") String query, @Field("gender") String gender, @Field("weight_kg") double weight, @Field("height_cm") double height, @Field("age") int age);

}