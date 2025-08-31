package com.example.hotel_booking.booking;

import com.example.hotel_booking.auth.JwtService;
import com.example.hotel_booking.user.UserEntity;
import com.example.hotel_booking.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    // Save booking
    @PostMapping
    public BookingEntity saveBooking(@RequestBody BookingEntity booking, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);

        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        booking.setUser(userOpt.get()); // set logged-in user
        return bookingService.save(booking);
    }

    // Get bookings for logged-in user
    @GetMapping("/my")
    public List<BookingEntity> getMyBookings(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingService.findByUser(user);
    }
}
