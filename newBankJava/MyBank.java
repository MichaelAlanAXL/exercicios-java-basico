import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyBank {

    static Scanner scanner = new Scanner(System.in);

    Account conta;

    static int nextAccountNumber = 1;

    static List<Account> contas = new ArrayList<>();
    
    // criar conta
    public void createNewAccount() {                
        System.out.println("Qual o seu nome?");
        var name = scanner.nextLine();

        System.out.println("Agora qual é a sua idade?");
        var age = scanner.nextInt();
        scanner.nextLine();

        if (age < 16) {
            System.out.println("Você precisar ter mais de 16 anos para abrir a conta");
            return;
        }        

        System.out.println("Qual valor deseja depositar na sua conta? (ex: digite 500 para R$500,00)");
        var balance = scanner.nextDouble();
        scanner.nextLine();

        if (balance < 50) {
            System.out.println("O valor mínimo para abrir conta é de R$50,00");
            return;
        }        
        
        double credit;

        if (balance <= 500) {
            credit = 50;
        } else {
            credit = balance / 2;
        }
        
        String accountNumberFormatted = String.format("%04d", nextAccountNumber);

        Account conta = new Account(name, age, accountNumberFormatted, balance, credit);
        
        contas.add(conta);

        System.out.println("Conta criada! Seu número de conta é: " + conta.getAccountNumber());

        nextAccountNumber++;

    }

    // ver dados da conta
    public void viewAccount() {
        System.out.println("Digite o número da sua conta (ex: 0001):");
        String inputNumber = scanner.nextLine();

        for (Account conta : contas) {
            if (conta.getAccountNumber().equals(inputNumber)) {
                System.out.println("Nome: " + conta.getName());
                System.out.println("Idade: " + conta.getAge());
                System.out.println("Numero da conta: " + conta.getAccountNumber());
                System.out.printf("Saldo da conta: R$%.2f%n", conta.getBalance());
                System.out.printf("Cheque especial: R$%.2f%n", conta.getCredit());
                return;
            }
        }
        System.out.println("Conta não encontrada.");
        
    }

    private boolean hasAccounts() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta criada.");
            return false;
        }
        return true;
    }

    // consultar saldo
    public void checkBalance() {
        if (!hasAccounts()) return;

        Account conta = contas.get(contas.size() -1);
        System.out.printf("Saldo da conta %s: R$%.2f%n", conta.getAccountNumber(), conta.getBalance());

    }

    // consultar cheque especial
    public void checkCreditLimit() {
        if (!hasAccounts()) return;

        Account conta = contas.get(contas.size() -1);
        System.out.printf("valor cheque especial: R$%.2f%n", conta.getCredit());

    }

    // Depositar dinheiro
    public void deposit() {
        if (!hasAccounts()) return;

        System.out.println("Digite o número da conta para depositar");
        String inputNumber = scanner.nextLine();

        for (Account conta : contas) {
            if (conta.getAccountNumber().equals(inputNumber)) {
                System.out.println("Digite o valor a depositar:");
                double newBalance = scanner.nextDouble();
                scanner.nextLine();

                if (conta.getCredit() < conta.getOriginalCredit()) {
                    double valorUsadoDoCredito = conta.getOriginalCredit() - conta.getCredit();
                    double juros = valorUsadoDoCredito * 0.20;
                    double divida = valorUsadoDoCredito + juros;
                    
                    if (newBalance >= divida) {
                        conta.setCredit(conta.getOriginalCredit());
                        conta.setBalance(newBalance - divida);
                    } else {
                        conta.setCredit(conta.getCredit() + newBalance);                        
                    }
                    
                } else {
                    conta.setBalance(conta.getBalance() + newBalance);
                    
                }
                System.out.printf("Depósito realizado!\n");
                return;
            }
        }
        System.out.println("Conta não encontrada.");

    }

    // sacar
    public void withdraw() { 
        if (!hasAccounts()) return;

        System.out.println("Digite o número da conta que deseja sacar");        
        String inputNumber = scanner.nextLine();

        for (Account conta : contas) {
            if (conta.getAccountNumber().equals(inputNumber)) {
                System.out.println("Digite o valor que deseja sacar");

                double saque = scanner.nextDouble();
                scanner.nextLine();

                if (saque <= conta.getBalance()) {
                    double novoSaldo = conta.getBalance() - saque;
                    conta.setBalance(novoSaldo);
                    
                } else if (saque <= (conta.getBalance() + conta.getCredit())) {
                    double restante = saque - conta.getBalance();
                    conta.setBalance(0);
                    conta.setCredit(conta.getCredit() - restante);

                    System.out.println("Foi usado o cheque especial e será cobrado 20% de juros no próximo deposito");                    
                    
                } else {
                    System.out.println("Saldo na conta não disponível, consulte o seu saldo");
                    
                }

            }
        }
    }

    // pagar boleto fazer pagamento
    public void makePayment() {
        if (!hasAccounts()) return;

        System.out.println("Digite o número da conta que deseja usar para pagar o boleto");
        String inputNumber = scanner.nextLine();

        for (Account conta : contas) {
            if (conta.getAccountNumber().equals(inputNumber)) {
                System.out.print("Digite o valor total do boleto\n");
                var valorBoleto = scanner.nextDouble();
                scanner.nextLine();
        
                if (valorBoleto <= conta.getBalance()) {
                    conta.setBalance(conta.getBalance() - valorBoleto);
                    System.out.println("Boleto pago");
                } else {
                    System.out.println("Saldo insuficiente para pagar o bolete, consulte o seu saldo");
                }

            }
        }


    }

    
}

/*
    Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:
    Consultar saldo
    consultar cheque especial
    Depositar dinheiro;
    Sacar dinheiro;
    Pagar um boleto.
    Verificar se a conta está usando cheque especial.
    Siga as seguintes regras para implementar
    
    A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
    O valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
    Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
    Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
    Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
 */
