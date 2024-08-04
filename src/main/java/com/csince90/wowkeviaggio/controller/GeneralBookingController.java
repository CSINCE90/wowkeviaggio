package com.csince90.wowkeviaggio.controller;

import com.csince90.wowkeviaggio.model.GeneralBooking;
import com.csince90.wowkeviaggio.service.GeneralBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class GeneralBookingController {

    @Autowired
    private GeneralBookingService generalBookingService;

    @GetMapping
    public List<GeneralBooking> getAllBookings() {
        return generalBookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralBooking> getBookingById(@PathVariable Long id) {
        Optional<GeneralBooking> booking = generalBookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GeneralBooking createBooking(@RequestBody GeneralBooking booking) {
        return generalBookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralBooking> updateBooking(@PathVariable Long id, @RequestBody GeneralBooking bookingDetails) {
        try {
            GeneralBooking updatedBooking = generalBookingService.updateBooking(id, bookingDetails);
            return ResponseEntity.ok(updatedBooking);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        generalBookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}