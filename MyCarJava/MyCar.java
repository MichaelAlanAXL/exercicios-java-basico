public class MyCar {
    public boolean carStatus = false;
    public int speed = 0;
    public int gear = 0;
    
    public void startCar() {
        if (carStatus) {
            System.out.println("O carro já foi ligado.");
        } else if (gear != 0 || speed != 0) {
            System.out.println("Para ligar o carro, coloque em neutro e pare o veículo.");
        } else {
            carStatus = true;
            System.out.println("O carro foi ligado.");
        }

    }

    public void turnOff() {
        if (!carStatus) {
            System.out.println("O carro já está desligado.");
        } else if (speed != 0) {
            System.out.println("Pare o carro antes de desligar.");
        } else {
            carStatus = false;
            gear = 0;
            System.out.println("O carro foi desligado.");
        }
    }

    public void showStatus() {
        System.out.println("Carro ligado: " + carStatus + " | Velocidade: " + speed + " km/h | Marcha: " + gear);
    }

    public void upshift() {
        if (!carStatus) {
            System.out.println("Ligue o carro para trocar de marcha.");
            showStatus();
            return;
        }

        if (gear >= 6) {
            System.out.println("O carro já está na 6ª marcha.");
        } else {
            boolean podeSubir = false;

            switch (gear) {
                case 0 -> {
                    if (speed == 0) podeSubir = true;
                    else System.out.println("Pare o carro para sair do neutro.");
                }
                case 1 -> {
                    if (speed >= 17) podeSubir = true;
                    else System.out.println("Acelere mais para subir uma marcha.");
                }
                case 2 -> {
                    if (speed >= 37) podeSubir = true;
                    else System.out.println("Velocidade incompatível com a marcha.");
                }

                case 3 -> {
                    if (speed >= 57) podeSubir = true;
                    else System.out.println("Suba uma marcha.");
                }

                case 4 -> {
                    if (speed >= 77) podeSubir = true;
                    else System.out.println("Velocidade insuficiente para 5ª marcha.");
                }

                case 5 -> {
                    if (speed >= 97) podeSubir = true;
                    else System.out.println("Velocidade insuficiente coloque uma marcha maior.");
                }

            }

            if (podeSubir) {
                gear += 1;
            }
        }

        showStatus();
    }

    public void downshift() {
        if (!carStatus) {
            System.out.println("Ligue o carro para trocar de marcha.");
            showStatus();
            return;
        }

        if (gear <= 0) {
            System.out.println("Já está em neutro.");
        } else {
            boolean podeReduzir = false;
            switch (gear) {
                case 1 -> {
                    if (speed <= 20) podeReduzir = true;
                    else System.out.println("Pare o caro antes de colocar em netro.");
                }
                case 2 -> {
                    if (speed <= 20 ) podeReduzir = true;
                    else System.out.println("Diminua a velocidade antes de reduzir para 1ª marcha.");
                }
                case 3 -> {
                    if (speed <= 40) podeReduzir = true;
                    else System.out.println("Reduza mais a velocidade.");
                }
                case 4 -> {
                    if (speed <= 60) podeReduzir = true;
                    else System.out.println("Reduza a velocidade.");
                }
                case 5 -> {
                    if (speed <= 80) podeReduzir = true;
                    else System.out.println("Reduza a velocidade para ir à 4ª marcha.");
                }
                case 6 -> {
                    if (speed <= 100) podeReduzir = true;
                    else System.out.println("Reduza a velocidade para ir à 5ª marcha.");
                }

            }

            if (podeReduzir) {
                gear -= 1;
            }        
        }

        showStatus();
    }

    public void accelerate() {
        if (!carStatus) {
            System.out.println("Ligue o carro antes de acelerar.");
            return;
        }

        if (gear == 0) {
            System.out.println("Coloque uma marcha antes de acelerar.");
            return;
        }

        int velocidadeMaxima = switch (gear) {
            case 1 -> 20;
            case 2 -> 40;
            case 3 -> 60;
            case 4 -> 80;
            case 5 -> 100;
            case 6 -> 120;
            default -> 0;
        };

        if (speed >= velocidadeMaxima) {
            System.out.println("Velocidade máxima da " + gear + "ª marcha atingida. Troque para a próxima marcha.");
        } else {
            int incremento = gear;
            speed += incremento;  
            
            if (speed > 120) speed = 120;

            System.out.println("Acelerando...");
        }

        showStatus();

    }

    public void decelerate() {        
        if (speed + gear > 0) {
            speed -= 1;
            System.out.println("Reduzindo velocidade...");
        }

        showStatus();
        
    }

    public void turnRight() {
        if (speed > 0) {
            System.out.println("Virando à direita.");
        }

        showStatus();

    }

    public void turnLeft() {
        if (speed > 0) {
            System.out.println("Virando à esquerda.");
        }

        showStatus();
    }    
}
