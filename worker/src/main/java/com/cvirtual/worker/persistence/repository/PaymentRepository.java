package com.cvirtual.worker.persistence.repository;

import com.cvirtual.worker.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public Payment findByName(String name);
    
}
