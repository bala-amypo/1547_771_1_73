// package com.example.demo.dto;

// public class AuthRequest {

//     private String username;
//     private String password;

//     public AuthRequest() {}

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     // 🔥 REQUIRED FOR TEST CASES
//     public void setUsernameOrEmail(String value) {
//         this.username = value;
//     }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
// }



package com.example.demo.dto;

public class AuthRequest {
    private String usernameOrEmail;
    private String password;

    public String getUsernameOrEmail() { return usernameOrEmail; }
    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
