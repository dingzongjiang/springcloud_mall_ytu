package com.example.mall.commons.entity;

import lombok.Data;

@Data
public class AliPay {
    private String subject;
    private String traceNo;
    private String totalAmount;
}
