package com.example.hotel_booking.payment;

import com.example.hotel_booking.booking.BookingEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String status; // e.g., SUCCESS, FAILED, PENDING

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private BookingEntity booking;
}
