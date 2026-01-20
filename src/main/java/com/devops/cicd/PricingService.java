package com.devops.cicd;


public final class PricingService {

    private final PricingConfig config;

    public PricingService(PricingConfig config) {
       this.config = config;
    }

    public double applyVat(double amountExclVat) {
        return amountExclVat + ((amountExclVat * config.getVatRate() / 100));
    }

    public double applyVipDiscount(double amount, boolean vip) {
        if(vip == true){
            return amount - (amount * 0.10);
        }else{
            return amount;
        }
    }

    public double shippingCost(double amount) {
        if(amount >= this.config.getFreeShippingThreshold()){
            return 0;
        }else{
            return 4.99;
        }
    }

    /**
     * - TVA appliquée d'abord : HT -> TTC
     * - remise VIP appliquée sur TTC
     * - frais de livraison ajoutés ensuite (calculés sur TTC)
     */
    public double finalTotal(double amountExclVat, boolean vip) {
        double finalPrice = this.applyVipDiscount(this.applyVat(amountExclVat), vip);
        finalPrice +=  this.shippingCost(finalPrice);
        return finalPrice;
    }
}
