package com.example.lesson07_restapi;

import com.example.lesson07_restapi.models.Category;
import com.example.lesson07_restapi.models.MultipleResource;
import com.example.lesson07_restapi.models.Product;
import com.example.lesson07_restapi.responses.ListCategoryReponse;
import com.example.lesson07_restapi.responses.ListProductResponse;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    /**
     *
     * @return
     */
    @GET("api/product")
    Call<ListProductResponse> getListProduct();

    @GET("api/product/{id}")
    Call<Product> getProduct(@Path("id") long id);

    @DELETE("/api/product/{id}")
    Call<Void> deleteProdut(@Path("id") int id);

    @POST("api/product")
    Call<Product> createProduct(@Body Product product);

    @PUT("api/product/{id}")
    Call<Product> createProduct(@Body Product product, @Path("id") int id);

}
