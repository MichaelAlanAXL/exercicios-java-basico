import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);    
    public static void main(String[] args) {
        var option = -1;

        MyBank bank = new MyBank();        

        do {
            System.out.println("=== Escolha uma das opções ====\n");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Consultar dados da conta");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Consultar cheque especial");
            System.out.println("5 - Depositar dinheiro");
            System.out.println("6 - Fazer saque");
            System.out.println("7 - Pagar um boleto");
            System.out.println("0 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> bank.createNewAccount();
                case 2 -> bank.viewAccount();
                case 3 -> bank.checkBalance();
                case 4 -> bank.checkCreditLimit();
                case 5 -> bank.deposit();
                case 6 -> bank.withdraw();
                case 7 -> bank.makePayment();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }
        } while (true);

    }
}