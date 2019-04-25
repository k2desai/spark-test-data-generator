package me.desaikun.azuretest.generator.cusip;

public final class CusipLookup {

    public static String[] data;
    public static int MAX_SIZE;

    public static void generateTestCusips(int count) {

        data = new String[count];
        MAX_SIZE = count;

        for(int i=0; i<count; i++) {
            data[i] = "C" + i;
        }
    }

    public static String getCusip(int i) {
        if(i<data.length) {
            return data[i];
        } else {
            return "";
        }
    }
}
