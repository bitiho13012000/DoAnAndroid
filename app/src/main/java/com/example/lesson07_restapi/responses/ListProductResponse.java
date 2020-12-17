package com.example.lesson07_restapi.responses;

import com.example.lesson07_restapi.models.Product;
import com.example.lesson07_restapi.models.ProductList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListProductResponse extends BaseResponse {
    @SerializedName("data")
    public List<Product> products;

}
