package com.example.lesson07_restapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("categories_id")
    @Expose
    public Integer categoriesId;
    @SerializedName("p_name")
    @Expose
    public String pName;
    @SerializedName("p_code")
    @Expose
    public String pCode;
    @SerializedName("p_color")
    @Expose
    public String pColor;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("quantity")
    @Expose
    public Integer quantity;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;


}
