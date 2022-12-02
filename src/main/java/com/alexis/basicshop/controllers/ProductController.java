package com.alexis.basicshop.controllers;

import com.alexis.basicshop.models.Product;
import com.alexis.basicshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable Long id) {
        Optional<Product> product = productService.getProduct(id);
        if(product.isPresent()) {
            return ResponseEntity.ok().body(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("products/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/save").toUriString());
        return ResponseEntity.created(uri).body(productService.saveProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if(productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }




}