package me.desaikun.azuretest.model;

public class FactorExposure {

    public String cusip;
    public double[] factorSensitivity;

    public FactorExposure(String cusip, double[] factorSensitivity) {
        this.cusip = cusip;
        this.factorSensitivity = factorSensitivity;
    }

    public double getFactorSensitivity(int factor) {

        if(factor < factorSensitivity.length) {
            return factorSensitivity[factor];
        } else {
            return 0.0;
        }
    }

}
