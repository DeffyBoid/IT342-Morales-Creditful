package edu.cit.morales.creditful.service;

import edu.cit.morales.creditful.entity.User;
import edu.cit.morales.creditful.repository.UserRepository;
import edu.cit.morales.creditful.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String register(String email, String password, String firstname, String lastname) throws Exception {
        if (userRepository.existsByEmail(email)) {
            throw new Exception("Email already registered");
        }

        String encodedPassword = passwordEncoder.encode(password);

        User newUser = new User(email, encodedPassword, firstname, lastname);
        newUser.setRole("BORROWER"); // default role
        userRepository.save(newUser);

        // Generate JWT
        return jwtUtil.generateToken(newUser.getEmail(), newUser.getRole());
    }
}
