package application;

import model.Account;
import service.AccountService;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        AccountService service = new AccountService();

        System.out.println("Welcome to Arumik Bank!");
        System.out.print("Enter your ID: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String menu = """
            (1 - Deposit)
            (2 - Show account details)
            (3 - Withdraw)
            (4 - Change account holder name)
            (5 - Exit)
            """;

        Account account = new Account(number, name, 0);
        int option;

        do {
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    service.deposit(account, depositAmount);
                    System.out.println("You deposited: " + depositAmount);
                    System.out.println("Balance: " + account.getBalance());
                    System.out.println(service.showAccount(account));
                }
                case 2 -> {
                    System.out.println("Account details:");
                    System.out.println(service.showAccount(account));
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount (Fee $5.00): ");
                    double withdrawAmount = sc.nextDouble();
                    service.withdraw(account, withdrawAmount);
                    System.out.println("Account details:");
                    System.out.println(service.showAccount(account));
                }
                case 4 -> {
                    System.out.print("Do you really want to change the holder name? (Y/N): ");
                    char answer = sc.next().charAt(0);
                    sc.nextLine();

                    if (answer == 'Y') {
                        System.out.print("Enter the new name: ");
                        String newName = sc.nextLine();
                        service.changeHolder(account, newName);
                        System.out.println("Account details:");
                        System.out.println(service.showAccount(account));
                    } else {
                        System.out.println("Ok, returning to menu...");
                    }
                }
                case 5 -> System.out.println("Closing...");
                default -> System.out.println("Option not recognized.");
            }
        } while (option != 5);

        sc.close();
    }
}