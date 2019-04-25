package me.desaikun.azuretest.model;

import java.util.LinkedList;
import java.util.List;



public class Account {

    public String accountNumber;
    public List<Position> portfolio = new LinkedList<>();

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void addPosition(String cusip, double deltaExposure) {
        this.portfolio.add(new Position(cusip, deltaExposure));
    }

    public static class Position {

        public String cusip;
        public double deltaExposure;

        public Position(String cusip, double deltaExposure) {
            this.cusip = cusip;
            this.deltaExposure = deltaExposure;
        }
    }

}
