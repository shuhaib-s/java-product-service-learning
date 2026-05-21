package com.practieceproject.todoproject.repository;

import com.practieceproject.todoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByDescription(String description);

    Product findByTitle(String title);

    Product save(Product p);




}
