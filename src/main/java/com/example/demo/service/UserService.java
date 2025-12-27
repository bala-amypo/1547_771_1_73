// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {

//     User registerUser(User user, String roleName);

//     User findByUsername(String username);
// }




package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(User user, String roleName);

    User findByUsername(String username);

    // ✅ ADD THIS
    User findByUsernameOrEmail(String value);
}
