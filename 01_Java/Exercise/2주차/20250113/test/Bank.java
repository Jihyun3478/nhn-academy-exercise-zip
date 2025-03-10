package test;
public class Bank {
    class Account {
        static int interestRate;
        private String name;
        private int balance;
    
        public void deposit(int amount) {
            this.balance += amount;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    }
}

class Bank {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.deposit(100);

        BankAccount b2 = new BankAccount();
        b2.deposit(1000);
    }
}