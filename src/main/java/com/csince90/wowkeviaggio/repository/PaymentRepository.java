package com.csince90.wowkeviaggio.repository;

import com.csince90.wowkeviaggio.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}