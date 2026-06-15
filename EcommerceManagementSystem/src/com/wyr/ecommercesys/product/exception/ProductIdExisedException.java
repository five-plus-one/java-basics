package com.wyr.ecommercesys.product.exception;

public class ProductIdExisedException extends RuntimeException{
    public ProductIdExisedException(String message){
        super(message);
    }
}
