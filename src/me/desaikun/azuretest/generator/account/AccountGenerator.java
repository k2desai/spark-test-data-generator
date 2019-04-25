package me.desaikun.azuretest.generator.account;

import me.desaikun.azuretest.model.Callback;
import me.desaikun.azuretest.generator.cusip.CusipLookup;
import me.desaikun.azuretest.model.Account;

import java.util.Random;

import static me.desaikun.azuretest.generator.cusip.CusipLookup.MAX_SIZE;

public class AccountGenerator {

    private static Random random = new Random(1);
    private static int MEAN_POSITIONS_PER_ACCOUNT = 5_000;
    private static int STDEV_POSITIONS_PER_ACCOUNT = 500;

    public void generateAccounts(String timeId, int accounts, Callback<Account> accountCallback) {

        for(int i=0; i<accounts; i++) {

            String accountNumber = "A" + i;
            Account account = new Account(accountNumber);

            double numOfPositions = Math.floor((random.nextGaussian() * STDEV_POSITIONS_PER_ACCOUNT) + MEAN_POSITIONS_PER_ACCOUNT);

            for(int pos=0; pos < numOfPositions; pos++) {
                int cusipID = random.nextInt(MAX_SIZE);
                account.addPosition(CusipLookup.getCusip(cusipID), random.nextDouble() * 100_000);
            }

            accountCallback.call(timeId, account);
        }
    }
}
