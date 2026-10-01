public class Gerente implements Papel {

    private String nome;
    
    public Gerente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void executarTarefa() {
        System.out.println("Gerente executando tarefa.");
    }

}
