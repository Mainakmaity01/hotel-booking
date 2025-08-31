package com.example.hotel_booking.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final RazorpayStubClient razorpay;

    public PaymentController(PaymentService paymentService, RazorpayStubClient razorpay) {
        this.paymentService = paymentService;
        this.razorpay = razorpay;
    }

    // Simulate payment (for testing/demo)
    @PostMapping("/{bookingId}/simulate")
    public ResponseEntity<String> simulatePayment(@PathVariable Long bookingId) {
        String result = paymentService.simulatePayment(bookingId);
        return ResponseEntity.ok(result);
    }

    // Real/mock payment processing with amount
    @PostMapping("/{bookingId}/pay")
    public ResponseEntity<String> processPayment(@PathVariable Long bookingId,
                                                 @RequestParam double amount) {
        boolean success = paymentService.processPayment(bookingId, amount);
        return success
                ? ResponseEntity.ok("Payment processed successfully for booking ID: " + bookingId)
                : ResponseEntity.badRequest().body("Payment failed for booking ID: " + bookingId);
    }

    // Razorpay integration (dummy order)
    @PostMapping("/razorpay/{bookingId}")
    public ResponseEntity<String> razorpayOrder(@PathVariable Long bookingId) {
        String orderId = razorpay.createOrder(1000); // dummy amount, you can pass booking amount
        return ResponseEntity.ok("Razorpay order created for booking ID: " + bookingId + ", Order ID: " + orderId);
    }
}
