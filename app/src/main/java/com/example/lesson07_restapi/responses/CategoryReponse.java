package com.example.lesson07_restapi.responses;

import com.example.lesson07_restapi.models.Category;

import com.google.gson.annotations.SerializedName;

public class CategoryReponse extends BaseResponse {
    @SerializedName("data")
    public Category category;
}
