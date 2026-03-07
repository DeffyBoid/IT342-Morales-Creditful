package edu.cit.morales.creditful.controller;

import edu.cit.morales.creditful.entity.User;
import edu.cit.morales.creditful.service.AuthService;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ===== User Registration =====
    /* 
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            String token = authService.register(
                    request.getEmail(),
                    request.getPassword(),
                    request.getFirstname(),
                    request.getLastname()
            );

            return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", token));

        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    */

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> user) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);

        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        data.put("accessToken", "fake-jwt-token-12345");
        data.put("refreshToken", "fake-refresh-token-12345");

        response.put("data", data);
        response.put("error", null);
        response.put("timestamp", java.time.Instant.now().toString());

    return ResponseEntity.ok(response);

}
    // ===== DTO Classes =====
    public static class RegisterRequest {
        private String email;
        private String password;
        private String firstname;
        private String lastname;

        // Getters and Setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public String getFirstname() { return firstname; }
        public void setFirstname(String firstname) { this.firstname = firstname; }

        public String getLastname() { return lastname; }
        public void setLastname(String lastname) { this.lastname = lastname; }
    }

    public static class ApiResponse {
        private boolean success;
        private String message;
        private Object data;

        public ApiResponse(boolean success, String message, Object data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        // Getters
        public boolean isSuccess() { return success; }
        public String getMessage() { return message; }
        public Object getData() { return data; }
    }
}