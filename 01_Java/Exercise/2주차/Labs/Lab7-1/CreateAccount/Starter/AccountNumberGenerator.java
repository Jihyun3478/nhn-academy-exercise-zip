public class AccountNumberGenerator {
    private static AccountNumberGenerator accountNumberGenerator;
    private long nextAccountNumber;
    private long nextCardNumber;

    private AccountNumberGenerator() {}

    public static AccountNumberGenerator getAccountNumberGenerator() {
        if (accountNumberGenerator == null) {
            accountNumberGenerator = new AccountNumberGenerator();
        }
        return accountNumberGenerator;
    }

    public long nextAccountNumber() {
        return nextAccountNumber++;
    }

    public long nextCardNumber() {
        return nextCardNumber++;
    }
}
