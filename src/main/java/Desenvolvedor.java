public class Desenvolvedor implements Papel {

    private String nome;
    private String linguagem;

    
    public Desenvolvedor(String nome, String linguagem) {
        this.nome = nome;
        this.linguagem = linguagem;
    }

    public String getNome() {
        return nome;
    }
    
    public String getLinguagem() {
        return linguagem;
    }

    @Override
    public void executarTarefa() {
        System.out.println("Desenvolvedor executando tarefa.");
    }
}