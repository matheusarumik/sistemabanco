import model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void aumentarDepositoValido() {
        Account account = new Account(123, "Matheus", 100.0);

        account.deposit(50.0);

        Assertions.assertEquals(150.0, account.getBalance());
    }

    @Test
    void deveDescontarTaxaAoFazerSaque() {

        Account account = new Account(123, "Matheus", 100.0);

        // (Saque de 20 + 5 de taxa = 25 de desconto)
        account.withdraw(20.0);
        // Expectativa
        Assertions.assertEquals(75.0, account.getBalance());
    }

    @Test
    void naoDeixaSacarMaisQueOSaldo() {
        Account account = new Account(123, "Matheus", 10.0);

        //(Tentar sacar 20 sendo que o saldo é 10)
        account.withdraw(20.0);

        //(O saldo deve permanecer 10.0)
        Assertions.assertEquals(10.0, account.getBalance());
    }
}