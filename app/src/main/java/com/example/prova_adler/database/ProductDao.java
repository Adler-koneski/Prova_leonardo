package com.example.prova_adler.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.prova_adler.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Query("SELECT * FROM products ORDER BY name ASC")
    List<Product> getAllProducts();
}