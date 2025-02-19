import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, double balance, String accountHolderName){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
    }

    // Getters
    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: $ " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: $ " + amount);
        } else {
            System.out.println("Invalid or insufficient balance");
        }
    }

    public static boolean transaction(int type, Scanner scanner, BankAccount obj) {
        switch (type) {
            case 1:
                System.out.println("Enter Deposit Amount : ");
                obj.deposit(scanner.nextDouble());
                break;
            case 2:
                System.out.println("Enter Withdraw Amount : ");
                obj.withdraw(scanner.nextDouble());
                break;
            case 3:
                System.out.println("Your account balance is : " + obj.getBalance());
                break;
            case 4:
                System.out.println("Exiting.. ");
                return true;
            default:
                System.out.println("Invalid transaction type");
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account1 = new BankAccount("111233", 1000, "Gerald");

        do{
            System.out.println("Enter transaction: ");
            System.out.println("(1) Deposit");
            System.out.println("(2) Withdraw");
            System.out.println("(3) Check Balance");
            System.out.println("(4) Exit");
            int trans = scanner.nextInt();
            if(transaction(trans, scanner, account1)) break;
        } while (true);

        System.out.println("Final Balance: $ " + account1.getBalance());
    }
}
