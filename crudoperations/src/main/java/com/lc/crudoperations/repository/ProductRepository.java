package com.lc.crudoperations.repository;

import com.lc.crudoperations.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public Product getProductById(String productId) {
        return products.get(productId);
    }

    public void deleteProductById(String productId) {
        products.remove(productId);
    }

    public boolean isProductExist(String productId) {
        return products.containsKey(productId);
    }
}

