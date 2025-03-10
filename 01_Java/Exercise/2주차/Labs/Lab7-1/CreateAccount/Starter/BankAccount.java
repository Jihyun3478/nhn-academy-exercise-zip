import java.math.*;
import java.util.Scanner;

public class BankAccount {
    private long accountNumber;
    private String ownerName;
    private BigDecimal balance;

    public void setData(String ownerName, BigDecimal balance) {
        this.accountNumber = AccountNumberGenerator.getAccountNumberGenerator().nextAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }
}

class CreateAccount {
    protected static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BankAccount bankAccount1 = CreateAccount.createNewBankAccount("Vesper Lind", new BigDecimal("0.0"));
        BankAccount bankAccount2 = CreateAccount.createNewBankAccount("Jihyun Lee", new BigDecimal("0.0"));
        printBankAccount(bankAccount1);
        printBankAccount(bankAccount2);
 
        testDeposit(bankAccount1);
        printBankAccount(bankAccount1);

        testWithdraw(bankAccount2);
        printBankAccount(bankAccount2);
    }

    public static BankAccount createNewBankAccount(String ownerName, BigDecimal balance) {
        BankAccount newAccount = new BankAccount();
        
        newAccount.setData(ownerName, balance);
        return newAccount;
    }

    public static void printBankAccount(BankAccount account) {
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: " + account.getBalance());
    }

    public static void testDeposit(BankAccount account) {
        System.out.print("Enter amount to deposit: ");

        BigDecimal amount = new BigDecimal(sc.nextLine());
        account.deposit(amount);
    }

    public static void testWithdraw(BankAccount account) {
        System.out.print("Enter amount to withdraw: ");

        BigDecimal amount = new BigDecimal(sc.nextLine());
        if(amount.compareTo(account.getBalance()) > 0) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        account.withdraw(amount);
    }
}