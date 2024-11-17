# Banking System Simulation with GUI 
## Project Overview:
### Develop a banking system simulation application that allows users to:
- Create an account with personal details.
- Make deposits and withdrawals.
- Transfer funds between accounts.
- View account details and transaction history.

## Key Features:
### 1. User Registration:
 - Users can register by entering their name, email, address, and initial deposit.
 - The system will assign each user a unique account number.
### 2. Login:
 - Users will log in using a username (account number) and password.
 - Validate login credentials.
### 3. Account Management:
 - Account balance display: Show current balance.
 - Deposit: Users can deposit money into their account.
 - Withdrawal: Users can withdraw funds from their account (with sufficient balance).
 - Transfer: Allow users to transfer money between accounts, with a valid destination account number.
### 4. Transaction History:
 - Users can view their transaction history, including deposits, withdrawals, and transfers.
 - Each transaction will have a timestamp and details like the amount and type of transaction.
### 5. Secure Authentication:
 - Password protection for user accounts.
 - Use hashing (e.g., MD5 or SHA-256) for storing passwords securely.
### 6. File I/O or Database integration:
 - Use file I/O to save user account details and transaction history locally, or integrate with a 
   simple database (e.g., SQLite or MySQL) for persistent storage.
 - Implement serialization to save and load user account information.

## Technology Stack:
 - JavaFX or Swing for the GUI (JavaFX is more modern and has better design capabilities, but Swing is also a good choice for beginners).
 - Java Collections (List, Map) for storing user accounts and transactions in memory.
 - File I/O or Database (SQLite, MySQL) for data persistence.
 - Hashing (MD5, SHA-256) for password security.
 - Optional: JUnit for unit testing your code.

## Project Structure:
### 1. Main.java (Entry Point):
 - Launches the application and handles the initialization of the GUI.
### 2. BankingSystem.java:
 - Contains the core logic of the system (creating accounts, handling transactions, etc.).
 - This is where you will define the data structures (e.g., a Map<Integer, UserAccount>) and methods for deposit, withdrawal, etc.
### 3. UserAccount.java:
 - Represents a user’s account. It includes the account number, balance, and transaction history.
 - Methods for deposit, withdrawal, and transfer would be implemented here.
### 4. Transaction.java
 - Represents a financial transaction (deposit, withdrawal, transfer). Includes transaction type, amount, and timestamp.
### 5. GUI Components:
 - LoginScreen.java: Login form where users enter their credentials.
 - MainMenu.java: After login, the user accesses the main menu to make transactions.
 - AccountOverview.java: Displays user account details, balance, and recent transactions.
 - Deposit/Withdrawal/Transfer Screens: Forms for the user to interact with.
