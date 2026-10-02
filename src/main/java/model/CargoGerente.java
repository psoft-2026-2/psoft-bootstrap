package model;

public class CargoGerente implements Cargo {
    @Override
    public void executar() {
        System.out.println("Gerenciando o time.");
    }
}
