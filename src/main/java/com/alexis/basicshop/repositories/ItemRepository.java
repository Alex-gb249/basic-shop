package com.alexis.basicshop.repositories;

import com.alexis.basicshop.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
