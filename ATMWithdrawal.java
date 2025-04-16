// src/ATMWithdrawal.java
import java.util.Scanner;

public class ATMWithdrawal {
    private static final int PIN = 1234;
    private static double balance = 3000.0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


        try {
            System.out.print("Enter PIN: ");
            int enteredPin = Integer.parseInt(scanner.nextLine());

            if (enteredPin != PIN) {
                throw new SecurityException("Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numbers only.");
        } catch (SecurityException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
        }

        scanner.close();
    }
    }
}
