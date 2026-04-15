package com.example.prova_adler;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prova_adler.database.ProductDatabase;
import com.example.prova_adler.model.Product;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etName, etCode, etPrice, etQuantity;
    private ProductDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o banco
        db = ProductDatabase.getInstance(this);

        // Liga os campos do XML com as variáveis
        etName     = findViewById(R.id.etName);
        etCode     = findViewById(R.id.etCode);
        etPrice    = findViewById(R.id.etPrice);
        etQuantity = findViewById(R.id.etQuantity);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnList = findViewById(R.id.btnList);

        // Botão cadastrar
        btnSave.setOnClickListener(v -> saveProduct());

        // Botão ver lista
        btnList.setOnClickListener(v ->
                startActivity(new Intent(this, ProductListActivity.class))
        );
    }

    private void saveProduct() {
        String name        = etName.getText().toString().trim();
        String code        = etCode.getText().toString().trim();
        String priceStr    = etPrice.getText().toString().trim();
        String quantityStr = etQuantity.getText().toString().trim();

        // Validação: campos vazios
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(code) ||
                TextUtils.isEmpty(priceStr) || TextUtils.isEmpty(quantityStr)) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validação: preço positivo com até 2 casas decimais
        double price;
        try {
            price = Double.parseDouble(priceStr);
            if (price <= 0) {
                Toast.makeText(this, "O preço deve ser maior que zero!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (priceStr.contains(".") && priceStr.split("\\.")[1].length() > 2) {
                Toast.makeText(this, "Preço com no máximo 2 casas decimais!", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Preço inválido!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validação: quantidade inteira positiva
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                Toast.makeText(this, "A quantidade deve ser maior que zero!", Toast.LENGTH_SHORT).show();
                return;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Quantidade inválida!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Salva no banco
        Product product = new Product(name, code, price, quantity);
        db.productDao().insert(product);

        Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        clearFields();
    }

    private void clearFields() {
        etName.setText("");
        etCode.setText("");
        etPrice.setText("");
        etQuantity.setText("");
        etName.requestFocus();
    }
}