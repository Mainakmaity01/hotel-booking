package com.example.hotel_booking.auth;

import com.example.hotel_booking.security.Role;
import com.example.hotel_booking.user.UserEntity;
import com.example.hotel_booking.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    // Register user
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            UserEntity user = new UserEntity();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword()); // will be encoded in service
            user.setRole(request.getRole() != null ? request.getRole() : Role.USER);

            userService.registerUser(user);

            return ResponseEntity.ok("✅ User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("❌ Error registering user: " + e.getMessage());
        }
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // authenticate using email + password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            // fetch user from DB
            UserEntity user = userService.findByEmail(request.getEmail());

            // generate JWT token
            String token = jwtService.generateToken(user.getEmail());

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Invalid credentials!");
        }
    }
}
