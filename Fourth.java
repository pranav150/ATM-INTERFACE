import java.util.Scanner;

public class Fourth {
    private BankAccount account;

    public Fourth(BankAccount account) {
        this.account = account;
    }

    public void withdraw(int amount) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient funds.");
        } else {
            account.withdraw(amount);
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    public void deposit(int amount) {
        account.deposit(amount);
        System.out.println(amount + " deposited successfully.");
    }

    public int checkBalance() {
        return account.getBalance();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter your account type: ");
        String accountType = scanner.next();
        System.out.print("Enter initial balance: ");
        int initialBalance = scanner.nextInt();
        BankAccount bankAccount = new BankAccount(name, accountNumber, accountType, initialBalance);
        Fourth atm = new Fourth(bankAccount);

        while (true) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    int amount = scanner.nextInt();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextInt();
                    atm.deposit(amount);
                    break;
                case 3:
                    System.out.println("Current balance: " + atm.checkBalance());
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

class BankAccount {
    private String name;
    private int accountNumber;
    private String accountType;
    private int balance;

    public BankAccount(String name, int accountNumber, String accountType, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
