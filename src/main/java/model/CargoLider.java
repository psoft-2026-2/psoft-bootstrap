package model;

public class CargoLider implements Cargo {
    @Override
    public void executar() {
        System.out.println("Liderando a sprint.");
    }
}
