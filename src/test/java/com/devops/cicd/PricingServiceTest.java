package com.devops.cicd;

// Change these imports to the Jupiter (JUnit 5) versions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    private final PricingConfig fakeConfig = new PricingConfig(20.0, 50.0);
    private final PricingService service = new PricingService(fakeConfig);

    @Test
    public void checkTax(){
        // JUnit 5 syntax (expected, actual)
        // You can now omit the delta if you wish, or add it as a 3rd param
        assertEquals(12.0, service.applyVat(10.0));
    }

    @Test
    public void checkShipping(){
        assertEquals(4.99, service.shippingCost(49));
        assertEquals(0, service.shippingCost(51));
        assertEquals(0, service.shippingCost(50.1));
    }

    @Test
    public void checkVipDiscount(){
        assertEquals(90,service.applyVipDiscount(100, true));
        assertEquals(100,service.applyVipDiscount(100, false));
    }

    @Test
    public void checkFinalTotal(){
        assertEquals(108.0,service.finalTotal(100, true));
        assertEquals(120,service.finalTotal(100, false));
    }
}