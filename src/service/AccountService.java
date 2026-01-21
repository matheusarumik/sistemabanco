package service;

import model.Account;

public class AccountService {

    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    public void changeHolder(Account account, String newHolder) {
        account.setHolder(newHolder);
    }

    public String showAccount(Account account) {
        return account.toString();
    }
}