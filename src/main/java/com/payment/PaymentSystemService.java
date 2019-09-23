package com.payment;

import java.util.Arrays;
import java.util.List;

public class PaymentSystemService {
    
    public PaymentSystem getPaymentSystem3(int systemId){
        PaymentSystem[] values = PaymentSystem.values();
        PaymentSystem result = null;
        for(int i = 0 ; i <values.length ; i ++ ) {
            if(values[i].getSystemId() == systemId){
                result = values[i];
            }
        }
        return result;
    }

    public PaymentSystem getPaymentSystem2(int systemId){
        PaymentSystem[] values = PaymentSystem.values();
        PaymentSystem result = null;
        for (PaymentSystem value : values) {
            if (value.getSystemId() == systemId) {
                result = value;
            }
        }
        return result;
    }

    public PaymentSystem getPaymentSystem(int systemId) {
        List<PaymentSystem> paymentSystems = Arrays.asList(PaymentSystem.values());
        return paymentSystems.stream()
                .filter(paymentSystem -> paymentSystem.getSystemId() == systemId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong system id!"));
    }
}
