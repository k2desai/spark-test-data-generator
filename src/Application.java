import me.desaikun.azuretest.generator.account.AccountGenerator;
import me.desaikun.azuretest.generator.cusip.CusipLookup;
import me.desaikun.azuretest.generator.factor.exposure.CusipFactorGenerator;
import me.desaikun.azuretest.generator.factor.returns.FactorReturnGenerator;
import me.desaikun.azuretest.writer.file.FactorExposureWriter;
import me.desaikun.azuretest.writer.file.FactorReturnWriter;
import me.desaikun.azuretest.writer.file.PositionFileWriter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class Application {

    private static int cusips = 100;
    private static int accounts = 100;

    AccountGenerator accountGenerator = new AccountGenerator();
    CusipFactorGenerator factorExposureGenerator = new CusipFactorGenerator();
    FactorReturnGenerator factorReturnGenerator = new FactorReturnGenerator();

    PositionFileWriter posWriter = new PositionFileWriter();
    FactorExposureWriter exposureWriter = new FactorExposureWriter();
    FactorReturnWriter returnWriter = new FactorReturnWriter();

    Application() {
        CusipLookup.generateTestCusips(cusips);
    }

    public void generateData() {

        LocalDate startDate = LocalDate.of(2019, 01,01);
        LocalDate endDate = LocalDate.of(2020, 01,01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        generateDatesBetween(startDate, endDate, date -> {

            String timeId = formatter.format(date);

            accountGenerator.generateAccounts(timeId, accounts, posWriter);
            factorExposureGenerator.generateCusipFactor(timeId, exposureWriter);
            factorReturnGenerator.generateFactorReturns(timeId, returnWriter);
        });
    }

    private static void generateDatesBetween(LocalDate startDate, LocalDate endDate, Consumer<LocalDate> consumer) {
        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        LongStream.range(0, numOfDays).mapToObj(i -> startDate.plusDays(i)).forEach(consumer);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.generateData();
    }
}
