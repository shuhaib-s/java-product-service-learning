package com.practieceproject.todoproject.controller;

import com.practieceproject.todoproject.model.Product;
import com.practieceproject.todoproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product p){
        return  this.productService.createProduct(p.getId(),p.getTitle(),p.getDescription(),p.getPrice(),p.getImageUrl(),p.getCategory());

    }

    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return this.productService.getProduct(id);
    }

    @GetMapping("/product")
    public List<Product> listProducts(){
        return this.productService.getAllProduct();
    }

    @PutMapping("product/{id}")
    public void updateProduct(@PathVariable("id") Long id){
      System.out.println("histted updated" );
   }
    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        System.out.println("histted delete" );

    }
}
