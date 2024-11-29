package octanet;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

	    private double balance;
	    private String pin;
	    private ArrayList<String> transactionHistory;

	    public ATM(double initialBalance, String initialPin) {
	        this.balance = initialBalance;
	        this.pin = initialPin;
	        this.transactionHistory = new ArrayList<>();
	        this.transactionHistory.add("Account created with balance: $" + initialBalance);
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            transactionHistory.add("Deposited: $" + amount);
	            System.out.println("Deposit successful.");
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            transactionHistory.add("Withdrew: $" + amount);
	            System.out.println("Withdrawal successful.");
	        } else {
	            System.out.println("Invalid withdrawal amount or insufficient balance.");
	        }
	    }

	    public void changePin(String oldPin, String newPin) {
	        if (this.pin.equals(oldPin)) {
	            this.pin = newPin;
	            transactionHistory.add("PIN changed.");
	            System.out.println("PIN change successful.");
	        } else {
	            System.out.println("Invalid old PIN.");
	        }
	    }

	    public boolean verifyPin(String inputPin) {
	        return this.pin.equals(inputPin);
	    }

	    public void printTransactionHistory() {
	        System.out.println("Transaction History:");
	        for (String transaction : transactionHistory) {
	            System.out.println(transaction);
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ATM atm = new ATM(1000.0, "1234");

	        System.out.println("Welcome to the ATM!");
	        System.out.print("Enter your PIN: ");
	        String inputPin = scanner.nextLine();

	        if (atm.verifyPin(inputPin)) {
	            while (true) {
	                System.out.println("\nATM Menu:");
	                System.out.println("1. Balance Inquiry");
	                System.out.println("2. Cash Deposit");
	                System.out.println("3. Cash Withdrawal");
	                System.out.println("4. Change PIN");
	                System.out.println("5. Transaction History");
	                System.out.println("6. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.println("Your current balance is: $" + atm.getBalance());
	                        break;
	                    case 2:
	                        System.out.print("Enter deposit amount: ");
	                        double depositAmount = scanner.nextDouble();
	                        atm.deposit(depositAmount);
	                        break;
	                    case 3:
	                        System.out.print("Enter withdrawal amount: ");
	                        double withdrawalAmount = scanner.nextDouble();
	                        atm.withdraw(withdrawalAmount);
	                        break;
	                    case 4:
	                        System.out.print("Enter old PIN: ");
	                        scanner.nextLine(); // consume newline
	                        String oldPin = scanner.nextLine();
	                        System.out.print("Enter new PIN: ");
	                        String newPin = scanner.nextLine();
	                        atm.changePin(oldPin, newPin);
	                        break;
	                    case 5:
	                        atm.printTransactionHistory();
	                        break;
	                    case 6:
	                        System.out.println("Thank you for using the ATM. Goodbye!");
	                        scanner.close();
	                        return;
	                    default:
	                        System.out.println("Invalid option. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid PIN. Access denied.");
	        }
	    }
	}


