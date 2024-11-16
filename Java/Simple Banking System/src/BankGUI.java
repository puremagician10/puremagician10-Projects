import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BankGUI extends JFrame {
    private Bank bank;

    public BankGUI() {
        bank = new Bank();
        setupMenuBar();
        setupUI();
    }

    private void setupUI() {
        setTitle("Enhanced Banking System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JButton btnAddAccount = new JButton("Add Account");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnViewAccount = new JButton("View Account");
        JButton btnViewTransactions = new JButton("View Transactions");
        JButton btnSaveData = new JButton("Save Data");
        JButton btnLoadData = new JButton("Load Data");
        JButton btnAddInterest = new JButton("Add Interest");
    JButton btnExportTransactions = new JButton("Export Transactions");

        panel.add(btnAddAccount);
        panel.add(btnDeposit);
        panel.add(btnWithdraw);
        panel.add(btnViewAccount);
        panel.add(btnViewTransactions);
        panel.add(btnSaveData);
        panel.add(btnLoadData);
        panel.add(btnAddInterest);
        panel.add(btnExportTransactions);

        add(panel);

        // Button Listeners
        btnAddAccount.addActionListener(e -> addAccount());
        btnDeposit.addActionListener(e -> deposit());
        btnWithdraw.addActionListener(e -> withdraw());
        btnViewAccount.addActionListener(e -> viewAccount());
        btnViewTransactions.addActionListener(e -> viewTransactions());
        btnSaveData.addActionListener(e -> saveData());
        btnLoadData.addActionListener(e -> loadData());
        btnAddInterest.addActionListener(e -> addInterest());
        btnExportTransactions.addActionListener(e -> exportTransactions());
    }

    private void addAccount() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        String holderName = JOptionPane.showInputDialog("Enter Holder Name:");
        
        if (accountNumber != null && holderName != null && !accountNumber.isEmpty() && !holderName.isEmpty()) {
            bank.addAccount(accountNumber, holderName);
            JOptionPane.showMessageDialog(null, "Account Created Successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input. Account not created.");
        }
    }

    private void deposit() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            String amountStr = JOptionPane.showInputDialog("Enter Amount to Deposit:");
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount > 0) {
                    account.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Deposit Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a numeric value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void withdraw() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            String amountStr = JOptionPane.showInputDialog("Enter Amount to Withdraw:");
            try {
                double amount = Double.parseDouble(amountStr);
                if (amount > 0 && amount <= account.getBalance()) {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Amount or Insufficient Funds.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a numeric value.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void viewAccount() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            JOptionPane.showMessageDialog(null, "Account Holder: " + account.getHolderName() + "\nBalance: " + account.getBalance());
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void viewTransactions() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            StringBuilder transactionHistory = new StringBuilder();
            for (Transaction t : account.getTransactions()) {
                transactionHistory.append(t.getType()).append(": ").append(t.getAmount()).append("\n");
            }
            JOptionPane.showMessageDialog(null, transactionHistory.length() > 0 ? transactionHistory.toString() : "No transactions yet.");
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void saveData() {
        try {
            bank.saveAccountsToFile("accounts.dat");
            JOptionPane.showMessageDialog(null, "Data saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try {
            bank.loadAccountsFromFile("accounts.dat");
            JOptionPane.showMessageDialog(null, "Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    private void addInterest() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(accountNumber);
    
        if (account != null) {
            account.calculateInterest();
            JOptionPane.showMessageDialog(null, "Interest added to account successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void exportTransactions() {
        String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
        String filename = JOptionPane.showInputDialog("Enter filename (e.g., transactions.txt):");
    
        try {
            bank.exportTransactionsToFile(accountNumber, filename);
            JOptionPane.showMessageDialog(null, "Transaction history exported to " + filename);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting transactions: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
    
        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save Data");
        JMenuItem loadItem = new JMenuItem("Load Data");
        JMenuItem exitItem = new JMenuItem("Exit");
    
        saveItem.addActionListener(e -> saveData());
        loadItem.addActionListener(e -> loadData());
        exitItem.addActionListener(e -> System.exit(0));
    
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    
        // View Menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem themeItem = new JMenuItem("Switch Theme");
    
        themeItem.addActionListener(e -> toggleTheme()); // Attach theme toggle logic
        viewMenu.add(themeItem);
    
        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
    
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Banking System v2.0\nCreated by Puremagician10"));
    
        helpMenu.add(aboutItem);
    
        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(viewMenu); // Add View menu to the menu bar
        menuBar.add(helpMenu);
    
        setJMenuBar(menuBar);
    }
    
    private void toggleTheme() {
        try {
            String currentLook = UIManager.getLookAndFeel().getName();
            if ("Nimbus".equals(currentLook)) {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } else {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error changing theme: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankGUI().setVisible(true));
    }
}
