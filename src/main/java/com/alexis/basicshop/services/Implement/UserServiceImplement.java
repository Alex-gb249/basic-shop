package com.alexis.basicshop.services.Implement;

import com.alexis.basicshop.models.Cart;
import com.alexis.basicshop.models.Role;
import com.alexis.basicshop.models.User;
import com.alexis.basicshop.repositories.CartRepository;
import com.alexis.basicshop.repositories.RoleRepository;
import com.alexis.basicshop.repositories.UserRepository;
import com.alexis.basicshop.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CartRepository cartRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {}.", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}.", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        log.info("Adding role {} to user {}", role.getName(), user.getName());
        user.getRoles().add(role);
    }

    @Override
    public void addCartToUser(String username, Long cartId) {
        User user = userRepository.findByUsername(username);
        Optional<Cart> cart = cartRepository.findById(cartId);
        if(cart.isPresent()) {
            log.info("Adding cart {} to user {}", cart.get().getId(), user.getName());
            user.setCart(cart.get());
        }

    }

    @Override
    public User getUser(String username) {
        log.info("Searching user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all users");
        return userRepository.findAll();
    }
}
