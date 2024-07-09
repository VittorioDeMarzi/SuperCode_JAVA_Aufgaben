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

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = transactionHistory;
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
            String transactionTime = getCurrentDateTime();
            this.balance += amount;
            String transaction = String.format("Deposit - %s - Amount: %s%n", transactionTime, nf.format(amount));
            this.transactionHistory.add(transaction);
        } else
            System.out.println("Incorrect amount. The account balance remains unchanged.");
    }

     public void withdraw(double amount) {
        if (amount < 0)
        System.out.println("Incorrect amount. The account balance remains unchanged.");
        else if (amount > this.balance)
        System.out.println("The account does not have sufficient funds.");
    else {
            String transactionTime = getCurrentDateTime();
            this.balance -= amount;
            String transaction = String.format("Withdraw - %s - Amount: %s%n", transactionTime, nf.format(amount));
            this.transactionHistory.add(transaction);
        }
    }
    
    private String getCurrentDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        return myDateObj.format(formatter);
    }

    public void printAccountInformation() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Account holder: " + this.accountHolder +
        " Account number: "+ this.accountNumber + 
        " Balance: " + nf.format(this.balance);
    }

    public void printHistory() {
        System.out.println("TRANSACTION HISTORY");
        for (String transaction : transactionHistory)
            System.out.println(transaction);
    }
    
}