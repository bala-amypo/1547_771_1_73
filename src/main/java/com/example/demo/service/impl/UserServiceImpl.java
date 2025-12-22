package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User registerUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName)
                .orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleName);
                    return roleRepository.save(r);
                });

        user.setRoles(new HashSet<>());
        user.getRoles().add(role);

        List<User> allUsers = userRepository.findAll();
        user.setId((long) (allUsers.size() + 1));
        allUsers.add(user);

        return user;
    }

    @Override
    public User findByUsername(String username) {
        List<User> allUsers = userRepository.findAll();
        for (User u : allUsers) {
            if (u.getUsername().equals(username)) return u;
        }
        return null; 
    }
}
