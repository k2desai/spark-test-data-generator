package me.desaikun.azuretest.writer.file;

import me.desaikun.azuretest.model.Account;

import java.util.function.BiFunction;

public class PositionFileWriter extends AbstractFileWriter<Account> {

    static BiFunction<Account, String, String> converter = (account, timeId) -> {

        StringBuffer buffer = new StringBuffer();
        for(Account.Position position : account.portfolio) {
                buffer.append(timeId + "," + account.accountNumber + "," + position.cusip + "," + position.deltaExposure);
                buffer.append("\n");
        }
        return buffer.toString();
    };

    public PositionFileWriter() {
        super(converter, "positions");
    }
}
