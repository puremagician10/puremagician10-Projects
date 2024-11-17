import java.util.HashMap;
import java.util.Map;

public class BankingSystem {

    private Map<Integer, UserAccount> accounts;

    public BankingSystem() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(int accountNumber, String name) {
        if (!accounts.containsKey(accountNumber)) {
            UserAccount account = new UserAccount(accountNumber, name);
            accounts.put(accountNumber, account);
        } else {
            System.out.println("Account already exists.");
        }
    }

    public UserAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(int accountNumber) {
        return accounts.containsKey(accountNumber);
    }
}
