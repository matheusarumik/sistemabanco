package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao banco arumik!");
        System.out.print("Informe seu ID: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Informe seu nome: ");
        String nome = sc.nextLine();
        String menu = (" (1 Para depositar: )\n (2 - Para não depositar: )\n (3 - Para  realizar um saque: )\n (4 - Para alterar o nome do titular: )\n (5 - Para sair: )");

        Account ban = new Account(number, nome, 0);
        int resposta;
        do {
            System.out.println(menu);
            resposta = sc.nextInt();
            sc.nextLine();
            switch (resposta) {
                case 1:
                    System.out.println("Informe o valor do deposito: ");
                    double valorDeposito = sc.nextDouble();
                    ban.deposit(valorDeposito);
                    System.out.println("Você depositou: " + valorDeposito);
                    System.out.println("Saldo: " + ban.getBalance());
                    System.out.println("Dados da conta: ");
                    System.out.println(ban);

                    break;
                case 2:
                    System.out.println("Você nao depositou: ");
                    System.out.println("Dados da conta: ");
                    System.out.println(ban);

                    break;
                case 3:
                    System.out.println("Informe o valor do saque (R$ 5.00 de taxa): ");
                    double valorSaque = sc.nextDouble();
                    ban.withdraw(valorSaque);
                    System.out.println("Dados da conta: ");
                    System.out.println(ban);

                    break;
                case 4:
                    System.out.print("Você realmente deseja alterar o seu nome? (S/N): ");
                    char resposta1 = sc.next().charAt(0);
                    sc.nextLine();

                    if (resposta1 == 'S') {
                        System.out.println("Informe o novo nome para ser atualizado no cadastro: ");
                        String novoNome = sc.nextLine();
                        ban.setHolder(novoNome);
                        System.out.println("Dados da conta: ");
                        System.out.println(ban);

                    } else {
                        System.out.println("Ok, retornando ao menu");
                    }
                    break;

                case 5:
                    System.out.println("Encerando...");
                    break;

                default:
                    System.out.println("Opção não recohecida.");
                    break;
            }
        } while (resposta != 5);
        sc.close();
    }
}
