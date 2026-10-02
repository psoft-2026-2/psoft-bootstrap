package model;

public class CargoDesenvolvedor implements Cargo {
    @Override
    public void executar() {
        System.out.println("Desenvolvendo funcionalidades do produto.");
    }
}
