package com.cvirtual.payroll;

import com.cvirtual.payroll.entity.Worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "worker", url = "http://localhost:8001", path = "/employee")
public interface WorkerFeignClient {
    
    @GetMapping("/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id);
}
