import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

// Class representing the ATM
class ATM {
    private BankAccount bankAccount;

    // Constructor to initialize ATM with the bank account
    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    // Method to display the ATM menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Your balance: $" + bankAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (option != 4);

        scanner.close();
    }
}

// Main class to run the ATM program
public class ATMSystem {
    public static void main(String[] args) {
        // Initialize a BankAccount with a starting balance
        BankAccount account = new BankAccount(1000.00); // $1000 initial balance
        
        // Create an ATM and link it with the user's bank account
        ATM atm = new ATM(account);
        
        // Show the ATM menu to the user
        atm.showMenu();
    }
}
