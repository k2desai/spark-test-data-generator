package me.desaikun.azuretest.model;

public interface Callback<T> {
    public void call(String timeId, T item);
    public void end();
}
