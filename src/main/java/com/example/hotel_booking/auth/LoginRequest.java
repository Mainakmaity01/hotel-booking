package com.example.hotel_booking.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
