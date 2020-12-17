package com.example.lesson07_restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lesson07_restapi.responses.ListProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView main_rv;
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_rv = findViewById(R.id.main_rv);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        loadProducts();
    }

    private void loadProducts() {
        apiInterface.getListProduct().enqueue(new Callback<ListProductResponse>() {
            @Override
            public void onResponse(Call<ListProductResponse> call, Response<ListProductResponse> response) {
                Log.e("success",response.body().products.size() + "");
                if (response.isSuccessful()) {
                    main_rv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    main_rv.setItemAnimator(null);
                    ProductAdapter productAdapter = new ProductAdapter(getApplicationContext(), response.body().products, id -> {
                        Intent intent = new Intent(getApplicationContext(), ProductDetail.class);
                        intent.putExtra("productID",id);
                        startActivity(intent);
                    });
                    main_rv.setAdapter(productAdapter);
                } else {
                    Log.e("Code", "asdfghjk");
                }
            }

//                 Log.e("success",response.body().categories.size() + "");
//                String displayResponse = "";
//
//                List<Category> datumList = response.body().categories;
//                for (Category category : datumList) {
//                    displayResponse += category.id + " \n" + category.parentId + " \n" + category.name + "\n " + category.description +
//                            "\n"+category.url+"\n"+category.status+"\n"+category.rememberToken+""+
//                            "\n"+ category.createdAt+ "\n" +category.updatedAt+
//                            "\n\n\n\n" ;
//                }
//                main_rv.setText(displayResponse);



            @Override
            public void onFailure(Call<ListProductResponse> call, Throwable t) {
                Log.e("failed", "failed");
            }//
        });
    }


}
