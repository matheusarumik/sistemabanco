package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account(int number, String holder, double balance) {
        this.number =  number;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        if (this.balance >= amount) {
            int taxa = 5;
            this.balance = this.balance - amount - taxa ;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }



    @Override
    public String toString() {
        return "Dados da conta: " +
                "ID: " + number +
                ", Titular: " + holder +
                ", Saldo: " + balance;
    }
}



