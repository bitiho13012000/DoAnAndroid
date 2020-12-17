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
    private TextView name;
    private TextView slug;
    private TextView price;
    private TextView salePrice;
    private TextView content;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        image = findViewById(R.id.ivItemDetailImage);
        name = findViewById(R.id.product_detail_name);
        categoriesId = findViewById(R.id.product_detail_category_id);
        slug = findViewById(R.id.product_detail_slug);
        salePrice = findViewById(R.id.product_detail_sale_price);
        content = findViewById(R.id.product_detail_content);
        price = findViewById(R.id.product_detail_price);
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
                    name.setText(product.name +"");
                    slug.setText(product.slug+"");
                    content.setText(product.content+"");
                    salePrice.setText(product.content + "");
                    price.setText(product.price + "$");
                    categoriesId.setText(product.categoryId);
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}