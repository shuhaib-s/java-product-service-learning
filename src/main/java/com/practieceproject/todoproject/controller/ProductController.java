package com.practieceproject.todoproject.controller;

import com.practieceproject.todoproject.Dto.ErrorDto;
import com.practieceproject.todoproject.Expections.ProductNotFoundException;
import com.practieceproject.todoproject.model.Product;
import com.practieceproject.todoproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
      Product p = this.productService.getProduct(id);
        ResponseEntity<Product> response = new ResponseEntity<>(
                p, HttpStatus.OK
        );
        return  response;

    }

    @GetMapping("/product")
    public List<Product> listProducts(){
        return this.productService.getAllProduct();
    }

    @PutMapping("product/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product p){

        return this.productService.updateProduct(
                p.getId(),
                p.getTitle(),
                p.getDescription(),
                p.getPrice(),
                p.getImageUrl(),
                p.getCategory()
        );

   }
    @DeleteMapping("product/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
       return this.productService.deleteProduct(id);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotfoudnExecption(Exception e){
        ErrorDto error = new ErrorDto();
        error.setMessage(e.getMessage());
        ResponseEntity<ErrorDto> err = new ResponseEntity<>(
                error, HttpStatus.NOT_FOUND
        );
        return  err;

    }
}
