import java.util.List;
import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private String cpf;
    private List<Papel> papeis;
    
    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.papeis =  new ArrayList<>();
    }

    public void adicionaPapel(Papel papel) {
        if (papel == null || papeis.contains(papel)) return;

        if (papel instanceof Gerente) {
            this.papeis.clear();
        } else if (papel instanceof ProductOwner) {
            this.papeis.clear();
        } else if (papel instanceof Lider) {
            if (!temPapel(Desenvolvedor.class)) {
                throw new IllegalArgumentException("Apenas um desenvolvedor pode assumir o papel de líder.");
            }
        } else if (papel instanceof Desenvolvedor) {
            this.papeis.removeIf(p -> p instanceof Gerente || p instanceof ProductOwner);
        }

        this.papeis.add(papel);
    }

    public void removePapel(Papel papel) {
        this.papeis.remove(papel); 
        
        if (papel instanceof Desenvolvedor && temPapel(Lider.class)) {
            this.papeis.remove(new Lider());
        }
    }

    public boolean temPapel(Class<? extends Papel> papel) {
        return papeis.stream().anyMatch(papel::isInstance);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
