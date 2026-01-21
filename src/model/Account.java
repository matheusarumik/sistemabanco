package model;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        int fee = 5;
        if (this.balance >= amount + fee) {
            this.balance -= amount + fee;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public String toString() {
        return "Account data: " +
                "ID: " + number +
                ", Holder: " + holder +
                ", Balance: " + String.format("%.2f", balance);
    }
}


