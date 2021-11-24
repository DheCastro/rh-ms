package com.cvirtual.worker.iservice;

import java.util.List;

import com.cvirtual.worker.entity.Payment;
import com.cvirtual.worker.vo.v1.PaymentVO;

public interface IPayment {
    public PaymentVO save(Payment payment);
	public PaymentVO findById(Long id);
	public List<PaymentVO> findAll();
	public PaymentVO findByName(String name);
	public void delete(Payment payment);
}
