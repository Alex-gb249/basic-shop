package com.alexis.basicshop.controllers;

import com.alexis.basicshop.models.Item;
import com.alexis.basicshop.models.Cart;
import com.alexis.basicshop.services.CartService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("carts/save")
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/carts/save").toUriString());
        return ResponseEntity.created(uri).body(cartService.saveCart(cart));
    }

    @PostMapping("items/save")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/items/save").toUriString());
        return ResponseEntity.created(uri).body(cartService.saveItem(item));
    }

    @PostMapping("items/addtocart")
    public ResponseEntity<?> addItemToCart(@RequestBody ItemToCartForm form) {
        cartService.addItemToCart(form.getCartId(), form.getItemId());
        return ResponseEntity.ok().build();
    }
}

@Data
class ItemToCartForm {
    private Long cartId;
    private Long itemId;
}
