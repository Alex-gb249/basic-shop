package com.alexis.basicshop.services;

import com.alexis.basicshop.models.Role;
import com.alexis.basicshop.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
