package com.payment;

public enum PaymentResult {
    SUCCESS("Success"), FAILURE("Failure");
    
    private String result;
    
    PaymentResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
