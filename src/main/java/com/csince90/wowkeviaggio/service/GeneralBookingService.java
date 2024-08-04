package com.csince90.wowkeviaggio.service;

import com.csince90.wowkeviaggio.model.GeneralBooking;
import com.csince90.wowkeviaggio.repository.GeneralBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralBookingService {

    @Autowired
    private GeneralBookingRepository generalBookingRepository;

    public List<GeneralBooking> getAllBookings() {
        return generalBookingRepository.findAll();
    }

    public Optional<GeneralBooking> getBookingById(Long id) {
        return generalBookingRepository.findById(id);
    }

    public GeneralBooking createBooking(GeneralBooking booking) {
        return generalBookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        generalBookingRepository.deleteById(id);
    }

    public GeneralBooking updateBooking(Long id, GeneralBooking bookingDetails) {
        GeneralBooking booking = generalBookingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setDataInizio(bookingDetails.getDataInizio());
        booking.setDataFine(bookingDetails.getDataInizio());
        booking.setProperty(bookingDetails.getProperty());
        booking.setUser(bookingDetails.getUser());
        return generalBookingRepository.save(booking);
    }
}