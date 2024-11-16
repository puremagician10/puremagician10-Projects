import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(String accountNumber, String holderName) {
        accounts.put(accountNumber, new Account(accountNumber, holderName));
    }

    public void removeAccount(String accountNumber) {
        accounts.remove(accountNumber);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    // Method to save accounts to a file
    public void saveAccountsToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(accounts);
        }
    }

    // Method to load accounts from a file
    public void loadAccountsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            accounts = (Map<String, Account>) ois.readObject();
        }
    }

    public void exportTransactionsToFile(String accountNumber, String filename) throws IOException {
        Account account = getAccount(accountNumber);
        if (account != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write("Transaction History for Account: " + accountNumber + "\n");
                writer.write("Holder Name: " + account.getHolderName() + "\n");
                writer.write("----------------------------------------\n");
                for (Transaction t : account.getTransactions()) {
                    writer.write(t.getType() + ": " + t.getAmount() + "\n");
                }
                writer.write("Current Balance: " + account.getBalance() + "\n");
            }
        } else {
            throw new IllegalArgumentException("Account not found.");
        }
    }
}
