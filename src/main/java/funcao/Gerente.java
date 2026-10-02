package funcao;

public class Gerente implements Funcao {
    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public void executar() {
        System.out.println("Gerenciando time e removendo impedimentos organizacionais");
    }
}