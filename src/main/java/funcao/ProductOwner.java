package funcao;

public class ProductOwner implements Funcao {
    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public void executar() {
        System.out.println("Supervisionando produtos: priorizando backlog, definindo visão, validando entregas");
    }
}