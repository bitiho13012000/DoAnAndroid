package com.example.lesson07_restapi.responses;

import com.example.lesson07_restapi.models.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCategoryReponse extends BaseResponse {
    @SerializedName("data")
    public List<Category> categories;
}
