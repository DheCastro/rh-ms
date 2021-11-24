package com.cvirtual.worker.service;

import java.util.ArrayList;
import java.util.List;

import com.cvirtual.worker.adapter.DozerAdapter;
import com.cvirtual.worker.entity.Payment;
import com.cvirtual.worker.iservice.IPayment;
import com.cvirtual.worker.persistence.repository.PaymentRepository;
import com.cvirtual.worker.vo.v1.PaymentVO;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService implements IPayment {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentVO save(Payment payment) {
        return DozerAdapter.parseObject(paymentRepository.save(payment), PaymentVO.class);
    }

    @Override
    public PaymentVO findById(Long id) {
        return DozerAdapter.parseObject(paymentRepository.findById(id).get(), PaymentVO.class);
    }

    @Override
    public List<PaymentVO> findAll() {
        List<PaymentVO> list = new ArrayList<>();

        paymentRepository.findAll().forEach(p -> list.add(DozerAdapter.parseObject(p, PaymentVO.class)));
        
        return list;
    }

    @Override
    public PaymentVO findByName(String name) {
        return DozerAdapter.parseObject(paymentRepository.findByName(name), PaymentVO.class);
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }
    
}
