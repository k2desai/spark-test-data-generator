package me.desaikun.azuretest.generator.factor.exposure;

import java.util.Random;

public class FactorExposureGenerator {

    public static final int NUMBER_FACTORS =  200;

    public static Random random = new Random(2);

    public static double[] generateTestFactorExposure() {

        double[] data = new double[NUMBER_FACTORS];
        for(int i=0; i<NUMBER_FACTORS; i++) {
            data[i] = random.nextDouble();
        }

        return data;
    }

    public static double[] generateFactorReturns() {
        return random.doubles(NUMBER_FACTORS, -0.1, 0.1).toArray();
    }
}
