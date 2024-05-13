package com.brian.springsecuritywithjsonwebtoken.repo;

import com.brian.springsecuritywithjsonwebtoken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
