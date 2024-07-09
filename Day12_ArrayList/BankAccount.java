
import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

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

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else
            System.out.println("Incorrect amount. The account balance remains unchanged.");
    }

    public void withdraw(double amount) {
        if (amount < 0)
            System.out.println("Incorrect amount. The account balance remains unchanged.");
        else if (amount > this.balance)
            System.out.println("The account does not have sufficient funds.");
        else
            this.balance -= amount;
    }
    
    public void printAccountInformation() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

        return "Account holder: " + this.accountHolder +
        " Account number: "+ this.accountNumber + 
        " Balance: " + nf.format(this.balance);
    }
    
    
}