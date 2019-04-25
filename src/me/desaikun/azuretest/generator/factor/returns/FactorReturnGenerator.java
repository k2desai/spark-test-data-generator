package me.desaikun.azuretest.generator.factor.returns;

import me.desaikun.azuretest.model.Callback;
import me.desaikun.azuretest.generator.factor.exposure.FactorExposureGenerator;

public class FactorReturnGenerator {

    public void generateFactorReturns(String timeId, Callback<double[]> factorReturnCallback) {

        double[] factorReturns = FactorExposureGenerator.generateFactorReturns();
        for (int i=0; i < factorReturns.length; i++){
            factorReturnCallback.call(timeId, factorReturns);
        }
    }
}