package com.brian.springsecuritywithjsonwebtoken.service;

import com.brian.springsecuritywithjsonwebtoken.model.Role;
import com.brian.springsecuritywithjsonwebtoken.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
