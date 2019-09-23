package com.payment;

public class PaymentService {
    
    public PaymentResult getPaymentResult(){
        return (int) (Math.random() + 1 ) == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }
}
