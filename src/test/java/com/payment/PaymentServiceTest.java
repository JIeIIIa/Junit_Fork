package com.payment;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentServiceTest {

    private PaymentService instance;

    @Before
    public void setUp() {
        instance = new PaymentService();
    }

    @Test
    public void paymentResultNotNull() {
        PaymentResult result = instance.getPaymentResult();

        assertNotNull(result);
    }

    @Test
    public void paymentResultIsRandom() {
        final int MAX_ITERATIONS = 5000;

        Map<PaymentResult, Long> result = Stream
            .generate(() -> instance.getPaymentResult())
            .limit(MAX_ITERATIONS)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        assertTrue(result.containsKey(PaymentResult.SUCCESS));
        assertTrue(result.containsKey(PaymentResult.FAILURE));
        double probability = result.get(PaymentResult.SUCCESS) / (double) result.get(PaymentResult.FAILURE);
        assertTrue(probability > 0.49);
    }
}