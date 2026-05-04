package com.practieceproject.todoproject.Expections;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception {
    private int code;
    public ProductNotFoundException(String message){
        super(message);
        this.code = 404;
    }


}
