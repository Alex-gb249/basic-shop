package com.alexis.basicshop.repositories;

import com.alexis.basicshop.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
