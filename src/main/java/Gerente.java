
public class Gerente implements Papel {

    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public String responsabilidades() {
        return "Gerencia o time e responde pelo andamento do produto.";
    }

    public void gerenciaTime() {
        System.out.println("Gerenciando o time...");
    }
}
