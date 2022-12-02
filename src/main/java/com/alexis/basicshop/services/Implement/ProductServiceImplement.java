package com.alexis.basicshop.services.Implement;

import com.alexis.basicshop.models.Product;
import com.alexis.basicshop.repositories.ProductRepository;
import com.alexis.basicshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("Problem deleting Product: " + e);
            return Boolean.FALSE;
        }
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
