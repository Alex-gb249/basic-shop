package com.alexis.basicshop.services.Implement;

import com.alexis.basicshop.models.Cart;
import com.alexis.basicshop.models.Item;
import com.alexis.basicshop.repositories.CartRepository;
import com.alexis.basicshop.repositories.ItemRepository;
import com.alexis.basicshop.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CartServiceImplement implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    public Cart saveCart(Cart cart) {
        log.info("Saving new user {}.", cart.getId());
        return cartRepository.save(cart);
    }

    @Override
    public Item saveItem(Item item) {
        log.info("Saving new item {}.", item.getId());
        return itemRepository.save(item);
    }

    @Override
    public void addItemToCart(Long cartId, Long itemId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Item> item = itemRepository.findById(itemId);
        if(cart.isPresent() && item.isPresent()){
            Cart actuallCart = cart.get();
            Item actuallItem = item.get();
            log.info("Adding item {} to cart {}", actuallItem.getId(), actuallCart.getId());
            actuallCart.getItems().add(item.get());
        }
    }

    @Override
    public Optional<Cart> getCart(Long id) {
        log.info("Searching cart by id: {}", id);
        return cartRepository.findById(id);
    }
}
