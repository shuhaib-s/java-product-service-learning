package com.practieceproject.todoproject.Expections;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message){
        super(message);
    }
}
