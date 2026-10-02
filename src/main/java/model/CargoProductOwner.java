package model;

public class CargoProductOwner implements Cargo {
    @Override
    public void executar() {
        System.out.println("Definindo prioridades do produto.");
    }
}
