package com.example.Backend.controller;

import com.example.Backend.model.SUser;
import com.example.Backend.repository.userRepository;
import com.example.Backend.DTO.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class registercontroller {
    @Autowired
    private  userRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<SUser> registerUser(@RequestBody SUser user) {
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);

        return ResponseEntity.ok().build();
    }
@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        // TO Find the user via email
        Optional<SUser> userOptional = userRepo.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            SUser user = userOptional.get();
            
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.ok("{\"message\": \"Login successful!\"}");
            }
        }
        
        // Error Handler
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid email or password\"}");
    }
    @GetMapping("/home")
    public String yes(){return "registered";}
}
