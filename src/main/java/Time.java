import java.util.List;
import java.util.Random;

public class Time {
    
    private Gerente gerente;
    private Desenvolvedor lider;
    private List<Desenvolvedor> equipe;
    private Produto produto;

    public Time(Gerente gerente, Desenvolvedor lider, Produto produto) {
        this.gerente = gerente;
        this.lider = lider;
        this.produto = produto;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Desenvolvedor getLider() {
        return lider;
    }

    public List<Desenvolvedor> getEquipe() {
        return equipe;
    }

    public Produto getProduto() {
        return produto;
    }

    public void tornarLider() {
        Random random = new Random();
        int indice = random.nextInt(equipe.size());
        lider = equipe.get(indice);        
    }
    
    public void adicionarDesenvolvedor(Desenvolvedor desenvolvedor) {
        equipe.add(desenvolvedor);
    }
}
