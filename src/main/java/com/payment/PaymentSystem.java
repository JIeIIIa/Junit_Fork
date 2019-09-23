package com.payment;

public enum PaymentSystem {
    APPLE_PAY(1), GOOGLE_PAY(2), VISA(3);

    private int systemId;
    
    PaymentSystem(int systemId) {
        this.systemId = systemId;
    }

    public int getSystemId() {
        return systemId;
    }
}
