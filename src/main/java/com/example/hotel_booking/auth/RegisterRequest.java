package com.example.hotel_booking.auth;

import com.example.hotel_booking.security.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
