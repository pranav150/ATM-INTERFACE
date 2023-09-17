import java.util.Scanner;

public class Third {
    private int balance;

    public Third(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public int checkBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        int initialBalance = scanner.nextInt();
        Third atm = new Third(initialBalance);

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
