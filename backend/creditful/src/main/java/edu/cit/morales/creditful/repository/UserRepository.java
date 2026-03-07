package edu.cit.morales.creditful.repository;

import edu.cit.morales.creditful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);           // Find a user by email (used for login & registration check)

    boolean existsByEmail(String email);                // Check if email already exists
}