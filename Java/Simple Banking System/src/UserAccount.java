import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    private int accountNumber;
    private String name;
    private double balance;
    private List<Transaction> transactionHistory;

    public UserAccount(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(UserAccount toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer", amount));
            return true;
        }
        return false;
    }
}
