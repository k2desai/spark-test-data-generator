package me.desaikun.azuretest.writer.file;

import me.desaikun.azuretest.model.FactorExposure;

import java.util.Arrays;
import java.util.function.BiFunction;

public class FactorExposureWriter extends AbstractFileWriter<FactorExposure> {

    static BiFunction<FactorExposure, String, String> converter = (data, timeId) -> {

        StringBuffer buffer = new StringBuffer();
        buffer.append(timeId + "," + data.cusip + "," + doubleArrayToString(data.factorSensitivity) + "\n");
        return buffer.toString();
    };

    private static String doubleArrayToString(double[] data) {
        return Arrays.stream(data).mapToObj(Double::toString).reduce((a,b) -> a + "," + b).orElse("");
    }


    public FactorExposureWriter() {
        super(converter, "factor_exposure");
    }
}