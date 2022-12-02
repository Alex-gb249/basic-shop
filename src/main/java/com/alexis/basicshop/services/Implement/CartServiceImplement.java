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

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CartServiceImplement implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void addItemToCart(Long cartId, Long itemId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        Optional<Item> item = itemRepository.findById(itemId);
        if(cart.isPresent() && item.isPresent()){
            Cart actuallCart = cart.get();
            actuallCart.getItems().add(item.get());
        }
    }

    @Override
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }
}
