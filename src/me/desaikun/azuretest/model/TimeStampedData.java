package me.desaikun.azuretest.model;

import java.time.LocalDate;

public class TimeStampedData<T> {

    public LocalDate date;
    public T data;

    private TimeStampedData(LocalDate date, T data) {
        this.date = date;
        this.data = data;
    }

    public static <T> TimeStampedData<T> stampDataForDate(T data, LocalDate date) {
        return new TimeStampedData<>(date, data);
    }
}
