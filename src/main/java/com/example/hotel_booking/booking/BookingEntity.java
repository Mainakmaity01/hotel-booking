package com.example.hotel_booking.booking;
import com.example.hotel_booking.hotel.HotelEntity;
import com.example.hotel_booking.room.RoomEntity;
import com.example.hotel_booking.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean paid;

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

}
