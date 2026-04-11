package edu.cit.morales.creditful.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cit.morales.creditful.entity.User;
import edu.cit.morales.creditful.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // secure password hashing
    }

    // ===== Registration =====
    public String register(String email, String password, String firstname, String lastname) throws Exception {
        if (userRepository.existsByEmail(email)) {
            throw new Exception("Email is already registered");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setFirstname(firstname);
        user.setLastname(lastname);

        userRepository.save(user);

        // Return fake token for now
        return "fake-jwt-token-12345";
    }

    // ===== Login =====
    public User login(String email, String password) throws Exception {
        // Check if user exists
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("User not found"));

        // Check password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid password");
        }

        return user; // successful login
    }
}