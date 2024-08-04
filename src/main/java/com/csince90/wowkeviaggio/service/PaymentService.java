package com.csince90.wowkeviaggio.service;

import com.csince90.wowkeviaggio.model.Payment;
import com.csince90.wowkeviaggio.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setAmount(paymentDetails.getAmount());
        payment.setDate(paymentDetails.getDate());
        payment.setGeneralBooking(paymentDetails.getGeneralBooking());
        payment.setUser(paymentDetails.getUser());
        return paymentRepository.save(payment);
    }
}