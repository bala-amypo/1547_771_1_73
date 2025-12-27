package com.example.demo.service.impl;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user, String roleName) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        String finalRoleName = roleName.startsWith("ROLE_")
                ? roleName
                : "ROLE_" + roleName;

        Role role = roleRepository.findByName(finalRoleName)
                .orElseGet(() -> roleRepository.save(new Role(finalRoleName)));

        user.setRoles(Set.of(role));
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameOrEmail(String value) {
        return userRepository.findByUsernameOrEmail(value, value)
                .orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
