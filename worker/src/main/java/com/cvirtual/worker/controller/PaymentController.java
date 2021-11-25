package com.cvirtual.worker.controller;

import java.util.List;

import com.cvirtual.worker.entity.Payment;
import com.cvirtual.worker.service.PaymentService;
import com.cvirtual.worker.vo.v1.PaymentVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<PaymentVO>> getAll() {
        List<PaymentVO> list = service.findAll();

        return new ResponseEntity<List<PaymentVO>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentVO> get(@PathVariable Long id) {
        PaymentVO payment = service.findById(id);
        HttpStatus status = (payment == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);

        return new ResponseEntity<>(payment, status);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PaymentVO> get(@PathVariable String name) {
        PaymentVO payment = service.findByName(name);
        HttpStatus status = (payment == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);

        return new ResponseEntity<>(payment, status);
    }

    @PostMapping
    public ResponseEntity<PaymentVO> save(@RequestBody Payment payment) {
        return new ResponseEntity<>(service.save(payment), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Payment payment) {
        service.delete(payment);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
