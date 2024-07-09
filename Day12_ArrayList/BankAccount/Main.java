package BankAccount;
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Vittorio De Marzi", "0445654", 135400.50);

        account1.printAccountInformation();
        account1.deposit(23000);
        account1.printAccountInformation();
        account1.deposit(-23000);
        account1.printAccountInformation();
        account1.withdraw(35000);
        account1.withdraw(35000);
        account1.withdraw(35000);
        account1.withdraw(35000);
        account1.printAccountInformation();
        account1.withdraw(300000);
        account1.printAccountInformation();
        account1.deposit(-23000);
        account1.printAccountInformation();
        account1.withdraw(35000);
        account1.printAccountInformation();
        account1.withdraw(300000);
        account1.printAccountInformation();

        account1.printHistory();
    }
}
