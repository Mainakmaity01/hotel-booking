package com.example.hotel_booking.payment;

import org.springframework.stereotype.Component;

@Component
public class RazorpayStubClient {
    public String createOrder(double amount) {
        return "RAZORPAY_ORDER_" + System.currentTimeMillis();
    }
}
