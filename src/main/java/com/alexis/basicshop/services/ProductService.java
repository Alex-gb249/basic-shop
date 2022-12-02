package com.alexis.basicshop.services;

import com.alexis.basicshop.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    Boolean deleteProduct(Long id);
    Optional<Product> getProduct(Long id);
    List<Product> getProducts();
}
