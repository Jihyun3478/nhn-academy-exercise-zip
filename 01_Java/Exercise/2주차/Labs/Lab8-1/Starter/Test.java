import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setData("James", new BigDecimal("100.0"));
        BankAccount account2 = new BankAccount();
        account2.setData("Jihyun", new BigDecimal("100.0"));

        System.out.println("Before transfer: ");
        displayAccountInfo(account1);
        displayAccountInfo(account2);

        account1.transferFrom(account2, new BigDecimal("10.0"));
        System.out.println("After transfer: ");
        displayAccountInfo(account1);
        displayAccountInfo(account2);
    }

    public static void displayAccountInfo(BankAccount account) {
        System.out.printf("AccountNo: %d. Owner: %s, balance: %s%n", account.getNumber(), account.getOwnerName(), account.getBalance());
    }
}
