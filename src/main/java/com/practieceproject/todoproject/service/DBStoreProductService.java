package com.practieceproject.todoproject.service;

import com.practieceproject.todoproject.model.Category;
import com.practieceproject.todoproject.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DBStoreProductService implements ProductService {


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, Category category) {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id,String title, String description, Double price, String imageUrl, Category category) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }
}
