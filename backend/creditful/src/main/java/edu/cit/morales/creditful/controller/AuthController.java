package edu.cit.morales.creditful.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cit.morales.creditful.dto.LoginRequest;
import edu.cit.morales.creditful.dto.RegisterRequest;
import edu.cit.morales.creditful.dto.UserResponse;
import edu.cit.morales.creditful.entity.User;
import edu.cit.morales.creditful.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3001")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ===== User Registration =====
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest request) {
        try {
            // Call service to register, returns token string
            String token = authService.register(
                    request.getEmail(),
                    request.getPassword(),
                    request.getFirstname(),
                    request.getLastname()
            );

            // Wrap token in UserResponse
            UserResponse response = new UserResponse(
                    true,
                    "User registered successfully",
                    token
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            UserResponse errorResponse = new UserResponse(
                    false,
                    e.getMessage(),
                    null
            );
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        try {
            User user = authService.login(request.getEmail(), request.getPassword());

            UserResponse response = new UserResponse(true, "Login successful", user);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            UserResponse response = new UserResponse(false, e.getMessage(), null);
            return ResponseEntity.status(403).body(response); // 403 = Forbidden
        }
    }
}