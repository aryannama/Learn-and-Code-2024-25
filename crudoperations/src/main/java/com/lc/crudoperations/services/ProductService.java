package com.lc.crudoperations.services;

import com.lc.crudoperations.exceptions.ProductNotFoundException;
import com.lc.crudoperations.model.Product;
import com.lc.crudoperations.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product addProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        productRepository.addProduct(product);
        return product;
    }

    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.getProductById(id);

        if (existingProduct == null) {
            throw new ProductNotFoundException(id);
        }

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return existingProduct;

    }

    public void deleteProduct(String id) {
        if (!productRepository.isProductExist(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteProductById(id);
    }
}
