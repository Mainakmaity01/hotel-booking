package com.example.hotel_booking.payment;

import com.example.hotel_booking.booking.BookingEntity;
import com.example.hotel_booking.booking.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final BookingRepository bookingRepository;

    // Real payment processing (mocked for now)
    public boolean processPayment(Long bookingId, double amount) {
        Optional<BookingEntity> bookingOpt = bookingRepository.findById(bookingId);

        if (bookingOpt.isEmpty()) {
            throw new RuntimeException("Booking not found with id: " + bookingId);
        }

        BookingEntity booking = bookingOpt.get();

        if (booking.getRoom() == null) {
            throw new RuntimeException("No room assigned to booking id: " + bookingId);
        }

        // Mock payment success (later integrate with Razorpay/Stripe)
        System.out.println("Processing payment of " + amount + " for booking id " + bookingId);

        return true;
    }

    // Simulated payment (for testing/demo)
    public String simulatePayment(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .map(booking -> "Payment successful for booking ID: " + bookingId)
                .orElse("Booking not found for ID: " + bookingId);
    }
}
