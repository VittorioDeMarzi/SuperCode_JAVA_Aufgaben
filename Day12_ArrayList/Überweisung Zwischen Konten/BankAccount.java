import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory = new ArrayList<>();
    private NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
    
    private final String WITHDRAW = "Withdraw";
    private final String DEPOSIT = "Deposit";

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
            this.transactionHistory = transactionHistory;
        }
        
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            insertTransactionInHistory(DEPOSIT, amount);
        } else
            System.out.println("Incorrect amount. The account balance remains unchanged.");
    }

    public void withdraw(double amount) {
        if (amount < 0)
            System.out.println("Incorrect amount. The account balance remains unchanged.");
        else if (amount > this.balance)
            System.out.println("The account does not have sufficient funds.");
        else {
            this.balance -= amount;
            insertTransactionInHistory(WITHDRAW, amount);
        }
    }
    
    public void transfer(BankAccount recipient, double amount) {
        if (amount < 0)
        System.out.println("Incorrect amount. The account balance remains unchanged.");
        else if (amount > this.balance)
        System.out.println("The account does not have sufficient funds.");
        else {
            this.balance -= amount;
            insertTransferInHistory(recipient, amount);
            recipient.balance += amount;
            insertReceiptInHistory(recipient, amount);
        }
    }
    
    private String getCurrentDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        return myDateObj.format(formatter);
    }

    private void insertTransactionInHistory(String kindOfTransaction, double amount) {
        String transactionTime = getCurrentDateTime();
        String transaction = String.format("%s - %s - Amount: %s - New Balance: %s%n", kindOfTransaction,
                transactionTime, nf.format(amount), nf.format(this.balance));
        this.transactionHistory.add(transaction);
    }
    
    private void insertTransferInHistory(BankAccount recipient, double amount) {
        String transactionTime = getCurrentDateTime();
        String transaction = String.format("Transfer - %s - Recipient: %s - Amount: %s - New Balance: %s%n", transactionTime, recipient.accountHolder, nf.format(amount), nf.format(this.balance));
        this.transactionHistory.add(transaction);
    }

    private void insertReceiptInHistory(BankAccount recipient, double amount) {
        String transactionTime = getCurrentDateTime();
        String transaction = String.format("Receipt - %s - Sender: %s - Amount: %s - New Balance: %s%n", transactionTime, this.accountHolder, nf.format(amount), nf.format(recipient.balance));
        recipient.transactionHistory.add(transaction);
    }

    public void printAccountInformation() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Account holder: " + this.accountHolder +
        ", Account number: "+ this.accountNumber + 
        ", Balance: " + nf.format(this.balance);
    }

    public void printHistory() {
        System.out.printf("TRANSACTION HISTORY of %s%n", this.accountHolder);
        for (String transaction : transactionHistory)
            System.out.println(transaction);
    }
    
}