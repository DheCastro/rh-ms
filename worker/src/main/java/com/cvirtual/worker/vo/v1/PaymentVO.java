package com.cvirtual.worker.vo.v1;

import lombok.Data;

@Data
public class PaymentVO {
    
    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;
}
