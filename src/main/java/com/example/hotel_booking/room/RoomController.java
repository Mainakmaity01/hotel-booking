package com.example.hotel_booking.room;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository repo;

    public RoomController(RoomRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<RoomEntity> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public RoomEntity save(@RequestBody RoomEntity room) {
        return repo.save(room);
    }
}
