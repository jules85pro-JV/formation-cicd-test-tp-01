package com.devops.cicd;

// Change these imports to the Jupiter (JUnit 5) versions
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingServiceTest {

    private final PricingConfig fakeConfig = new PricingConfig(20.0, 50.0);
    private final PricingService service = new PricingService(fakeConfig);

    @Test
    public void checkTax(){
        double var1 = 10.0;
        double var2 = 12.0;

        // JUnit 5 syntax (expected, actual)
        // You can now omit the delta if you wish, or add it as a 3rd param
        assertEquals(var2, service.applyVat(var1));
    }
}