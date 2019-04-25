package me.desaikun.azuretest.generator.factor.exposure;

import me.desaikun.azuretest.generator.cusip.CusipLookup;
import me.desaikun.azuretest.model.Callback;
import me.desaikun.azuretest.model.FactorExposure;

public class CusipFactorGenerator {

    public void generateCusipFactor(String timeId, Callback<FactorExposure> factorExposureCallback) {

        for (int i = 0; i < CusipLookup.MAX_SIZE; i++){
            String cusip = CusipLookup.getCusip(i);
            factorExposureCallback.call(timeId, new FactorExposure(cusip, FactorExposureGenerator.generateTestFactorExposure()));
        }
    }
}
