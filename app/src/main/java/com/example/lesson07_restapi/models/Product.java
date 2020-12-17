package com.example.lesson07_restapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("sale_price")
    @Expose
    public Integer salePrice;
    @SerializedName("category_id")
    @Expose
    public Integer categoryId;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

}