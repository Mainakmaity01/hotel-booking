package com.example.hotel_booking.booking;

import com.example.hotel_booking.user.UserEntity;
import com.example.hotel_booking.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository repo;

    public List<BookingEntity> findAll() {
        return repo.findAll();
    }

    public BookingEntity save(BookingEntity booking) {
        return repo.save(booking);
    }

    public List<BookingEntity> findByUser(UserEntity user) {
        return repo.findByUser(user);
    }
}
