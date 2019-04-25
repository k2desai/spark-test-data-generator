package me.desaikun.azuretest.writer.file;

import me.desaikun.azuretest.model.Callback;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public abstract class AbstractFileWriter<T>  implements Callback<T> {

    File writeDirectory = new File("C:\\Users\\Administrator\\data");

    private final BiFunction<T, String, String> converter;
    private final String filePrefix;

    public AbstractFileWriter(BiFunction<T, String, String> converter, String filePrefix) {
        this.converter = converter;
        this.filePrefix = filePrefix;
    }

    private final Map<String, BufferedWriter> files = new HashMap<>();

    @Override
    public void call(String timeId, T item) {


        BufferedWriter writer = files.computeIfAbsent(timeId, date -> {
            try {
                File file = new File(writeDirectory, filePrefix + "_" + date.toString() + ".csv");
                return new BufferedWriter(new FileWriter(file));
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        });

        try {
            writer.write(converter.apply(item, timeId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void end() {
        files.values().forEach( w -> {
            try {
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
