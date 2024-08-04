package com.csince90.wowkeviaggio.repository;

import com.csince90.wowkeviaggio.model.GeneralBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralBookingRepository extends JpaRepository<GeneralBooking, Long> {
}