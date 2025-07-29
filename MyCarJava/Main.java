
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyCar myCar = new MyCar();
        Scanner scanner = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("=== Escolha uma opção ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Desacelerar");
            System.out.println("5 - Subir uma marcha");
            System.out.println("6 - Reduzir uma marcha");
            System.out.println("7 - Virar à direita");
            System.out.println("8 - Virar à esquerda");
            System.out.println("0 - Sair");

            option = scanner.nextInt();
    
            switch (option) {
                case 1 -> myCar.startCar();
                case 2 -> myCar.turnOff();
                case 3 -> myCar.accelerate();
                case 4 -> myCar.decelerate();
                case 5 -> myCar.upshift();
                case 6 -> myCar.downshift();
                case 7 -> myCar.turnRight();
                case 8 -> myCar.turnLeft();
                case 0 -> System.exit(0);
                default ->System.out.println("Opção inválida");
            }
        }
        
        scanner.close();

    }
}
