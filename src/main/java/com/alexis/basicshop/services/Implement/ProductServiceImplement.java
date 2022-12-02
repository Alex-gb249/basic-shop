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
        log.info("Saving new product {}.", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        try{
            productRepository.deleteById(id);
            log.info("Deleted product {}.", id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("Problem deleting Product {id}: {}", id, e);
            return Boolean.FALSE;
        }
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        log.info("Searching product by id: {}", id);
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProducts() {
        log.info("Getting all products");
        return productRepository.findAll();
    }
}
