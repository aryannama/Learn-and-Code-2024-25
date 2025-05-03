package com.lc.crudoperations.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Product with ID " + id + " not found.");
    }
}
