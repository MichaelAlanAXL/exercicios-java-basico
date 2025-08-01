

public class PetMachine {

    private boolean clean = false;
    private int water = 30;
    private int shampoo = 10;

    private Pet pet;

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        if (this.water < 10 || this.shampoo < 2) {
            System.out.println("Erro: Não há água ou shampoo suficiente para dar banho no pet.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        this.clean = false;
        System.out.println("O Pet " + pet.getName() + " está limpo.");

    }

    public void addWater() {
        if (water == 30) {
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }

        water += 2;
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean) {
            System.out.println("A máquina está suja, para colocar o pet é necessário limpá-la");
            return;
        }

        if (hasPet()) {
            System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
            return;
        }

        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina");
    }

    public void removePet() {
        if (this.pet == null) {
            System.out.println("Não há pet na máquina.");
            return;
        }

        if (pet.isClean()) {
            System.out.println("O pet " + pet.getName() + " está limpo e foi removido da máquina.");
        } else {
            System.out.println("O pet " + pet.getName() + " está sujo e foi removido da máquina");
        }

        this.clean = false;
        this.pet = null;
    }

    public void cleanMachine() {
        if (this.clean) {
            System.out.println("A máquina já está limpa.");
            return;
        }

        if (this.water < 10 || this.shampoo < 2) {
            System.out.println("Erro: Não há água ou shampoo suficiente para limpar a máquina.");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina foi limpa!");
    }

    
}
