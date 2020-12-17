package com.example.lesson07_restapi;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson07_restapi.models.Product;

import com.example.lesson07_restapi.responses.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetail extends AppCompatActivity {
    private ImageView image;
    private TextView categoriesId;
    private TextView pName;
    private TextView pCode;
    private TextView pColor;
    private TextView description;
    private TextView price;
    private TextView quantity;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        image = findViewById(R.id.ivItemDetailImage);
        pName = findViewById(R.id.product_detail_name);
        categoriesId = findViewById(R.id.product_detail_category);
        pCode = findViewById(R.id.product_detail_code);
        pColor = findViewById(R.id.product_detail_color);
        description = findViewById(R.id.product_detail_description);
        price = findViewById(R.id.product_detail_price);
        quantity = findViewById(R.id.product_detail_quantity);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        loadProduct(getIntent().getLongExtra("productID", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    void loadProduct(long id) {
        apiInterface.getProduct(id).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    Product product = response.body();
                    pName.setText(product.pName +"");
                    pCode.setText(product.pCode+"");
                    pColor.setText(product.pColor+"");
                    description.setText(product.description + "");
                    price.setText(product.price + "$");
                    quantity.setText(product.quantity);
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}