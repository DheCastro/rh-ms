package com.cvirtual.worker.persistence.repository;

import com.cvirtual.worker.entity.Payment;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    public Payment findByName(String name);
    
}
