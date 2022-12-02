package com.alexis.basicshop.repositories;

import com.alexis.basicshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Collection<Product> findAllByNameContains(String product);
}
