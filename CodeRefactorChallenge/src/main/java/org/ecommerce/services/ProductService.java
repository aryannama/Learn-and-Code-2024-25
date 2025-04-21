package org.ecommerce.services;

import org.ecommerce.model.Order;
import org.ecommerce.model.OrderItem;
import org.ecommerce.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    public static Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            throw new IllegalArgumentException("Product Id should not be null or empty");
        }

        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Product price should not be negative");
        }
        products.put(product.getId(), product);
    }

    public void updateProductStock(Order order, boolean increaseStock) {
        for (OrderItem item : order.getItems()) {
            Product product = products.get(item.getProductId());
            if (product != null) {
                int updatedStock = increaseStock ? product.getStock() + item.getQuantity() : product.getStock() - item.getQuantity();
                product.setStock(updatedStock);
                products.put(item.getProductId(), product);
            }
        }
    }
}
