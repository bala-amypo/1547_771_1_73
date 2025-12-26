package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ----------------------------------------------------
    // Used in Auth & Security tests
    // ----------------------------------------------------
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    // For login using username OR email
    Optional<User> findByUsernameOrEmail(String username, String email);
}
