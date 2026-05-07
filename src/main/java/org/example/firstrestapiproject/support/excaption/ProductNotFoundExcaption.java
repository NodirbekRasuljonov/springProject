package org.example.firstrestapiproject.support.excaption;

public class ProductNotFoundExcaption extends RuntimeException {
    public ProductNotFoundExcaption(Long id) {
        super(String.format("Product with %d not found",id));


    }
}
