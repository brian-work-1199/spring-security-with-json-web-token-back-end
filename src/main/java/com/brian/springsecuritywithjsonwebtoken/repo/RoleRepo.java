package com.brian.springsecuritywithjsonwebtoken.repo;

import com.brian.springsecuritywithjsonwebtoken.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
