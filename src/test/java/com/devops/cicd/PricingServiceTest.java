package com.devops.cicd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PricingServiceTest {

    private final PricingConfig fakeConfig = new PricingConfig(20.0, 50.0);
    private final PricingService service = new PricingService(fakeConfig);

    @Test
    public void checkTax(){
        assertEquals(120,service.applyVat(100));
    }
}