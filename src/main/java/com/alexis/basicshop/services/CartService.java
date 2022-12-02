package com.alexis.basicshop.services;

import com.alexis.basicshop.models.Cart;
import com.alexis.basicshop.models.Item;

import java.util.List;

public interface CartService {
    Cart saveCart(Cart cart);
    Item saveItem(Item item);
    void addItemToCart(Long cartId, Long itemId);
    List<Cart> getCart();
}
