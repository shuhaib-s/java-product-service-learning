package com.practieceproject.todoproject.service;

import com.practieceproject.todoproject.Expections.ProductNotFoundException;
import com.practieceproject.todoproject.model.Category;
import com.practieceproject.todoproject.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Long id,String title, String description, Double price, String imageUrl, Category category);

    Product getProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProduct();

    Product updateProduct(Long id,String title, String description, Double price, String imageUrl, Category category);

    String deleteProduct(Long id);


}
