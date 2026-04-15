package com.example.prova_adler;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prova_adler.adapter.ProductAdapter;
import com.example.prova_adler.database.ProductDatabase;
import com.example.prova_adler.model.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Botão voltar
        TextView tvBack = findViewById(R.id.tvBack);
        tvBack.setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmpty = findViewById(R.id.tvEmpty);

        // Busca os produtos no banco
        ProductDatabase db = ProductDatabase.getInstance(this);
        List<Product> products = db.productDao().getAllProducts();

        // Se não houver produtos exibe mensagem
        if (products.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            // Configura o RecyclerView
            ProductAdapter adapter = new ProductAdapter(products);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }
}