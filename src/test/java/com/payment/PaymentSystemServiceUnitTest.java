package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PaymentSystemServiceUnitTest {

    private PaymentSystemService instance;

    @Before
    public void setUp() {
        instance = new PaymentSystemService();
    }

    @Test
    public void shouldReturnNullWhenPaymentSystemNotExist() {
        PaymentSystem result = instance.getPaymentSystem(0);
        
        assertNull(result);
    }

    @Test
    public void shouldReturnPaymentSystemWhenValidSystemId() {
        PaymentSystem paymentSystem = instance.getPaymentSystem(PaymentSystem.APPLE_PAY.getSystemId());
        
        assertNotNull(paymentSystem);
    }

    @Test
    public void shouldReturnAppleSystemWhenSystemIdOne() {
        PaymentSystem result = instance.getPaymentSystem(1);
        
        assertEquals(PaymentSystem.APPLE_PAY, result);
    }

    @Test
    public void shouldReturnGooglePayWhenSystemIdTwo () {
        PaymentSystem result = instance.getPaymentSystem(2);

        assertEquals(PaymentSystem.GOOGLE_PAY, result);
    }

    @Test
    public void shouldReturnVisaPayWhenSystemIdThree () {
        PaymentSystem result = instance.getPaymentSystem(3);

        assertEquals(PaymentSystem.VISA, result);
    }
}