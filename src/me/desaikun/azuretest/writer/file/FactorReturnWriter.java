package me.desaikun.azuretest.writer.file;

import java.util.function.BiFunction;

public class FactorReturnWriter extends AbstractFileWriter<double[]> {

    static BiFunction<double[], String, String> converter = (data, timeId) -> {

        StringBuffer buffer = new StringBuffer();
        for(int i=0; i< data.length; i++) {
            buffer.append(timeId + "," + i + "," + data[i] + "\n");
        }
        return buffer.toString();
    };


    public FactorReturnWriter() {
        super(converter, "factor_returns");
    }
}
