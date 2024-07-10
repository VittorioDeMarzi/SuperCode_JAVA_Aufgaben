
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Vittorio De Marzi", "044 5654", 135400.50);
        BankAccount account2 = new BankAccount("Aldo Baglio", "035 3992", 27000.90);
        account1.printAccountInformation();   
        account2.printAccountInformation();
        account1.transfer(account2, 27900);
        account1.printHistory();
        account2.printAccountInformation();
        account2.printHistory();
    }
}
