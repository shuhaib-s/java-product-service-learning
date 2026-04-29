package com.practieceproject.todoproject.Dto;

import com.practieceproject.todoproject.model.Category;
import com.practieceproject.todoproject.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FakestoreDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;


    public Product getProduct(){
        Product p= new Product();
        p.setId(id);
        p.setTitle(title);
        p.setImageUrl(image);
        p.setPrice(price);
        p.setDescription(description);

        Category c = new Category();
        c.setName(category);
        p.setCategory(c);
        return  p;

    }
}


