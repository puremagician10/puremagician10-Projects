import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactions;
    private double interestRate; // New field

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.interestRate = 0.02; // Default Interest rate (2%)
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        transactions.add(new Transaction("Interest Added", interest));
    }

    public void setInterestRate(double rate){
        this.interestRate = rate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
        }
    }

    public List<Transaction> getTransactions() { return transactions; }
}
