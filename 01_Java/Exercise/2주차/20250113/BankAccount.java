import java.math.BigDecimal;

public class BankAccount {
    BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal deposit(BigDecimal balance) {
        this.balance = this.balance.add(balance);

        return this.balance;
    }

    public BigDecimal withdraw(BigDecimal balance) {
        this.balance = this.balance.subtract(balance);

        return this.balance;
    }

    public String toString() {
        return "잔액은 " + balance + "원 입니다.";
    }
}

class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(new BigDecimal(5000));
        BankAccount account2 = new BankAccount(new BigDecimal(4000));

        account1.deposit(account2.balance);
        System.out.println(account1.toString());

        account1.withdraw(account2.balance);
        System.out.println(account1.toString());
    }
}