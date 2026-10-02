import java.util.*;

public class Funcionario {

    private String nome;
    private String cpf;
    private List<Papel> papeis = new ArrayList<>();

    public Funcionario(String nome, String cpf) {
        if (nome == null || nome.isBlank() || cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Nome e matrícula são obrigatórios.");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return cpf;
    }

    public List<Papel> getPapeis() {
        return this.papeis;
    }

    public boolean possuiPapel(Class<? extends Papel> tipo) {
        return getPapel(tipo).isPresent();
    }

    public <T extends Papel> Optional<T> getPapel(Class<T> tipo) {
        return papeis.stream().filter(tipo::isInstance).map(tipo::cast).findFirst();
    }

    /** Acrescenta um papel acumulável (ex.: Líder junto com Desenvolvedor). */
    public void assumirPapel(Papel papel) {
        if (papel.ehExclusivo()) {
            throw new IllegalArgumentException(
                    papel.getNome() + " é exclusivo; use substituirPapeis().");
        }
        if (papeis.stream().anyMatch(Papel::ehExclusivo)) {
            throw new IllegalStateException(
                    nome + " possui um papel exclusivo e não pode acumular " + papel.getNome());
        }
        if (possuiPapel(papel.getClass())) {
            throw new IllegalStateException(nome + " já possui o papel " + papel.getNome());
        }
        papeis.add(papel);
    }

    public void abandonarPapel(Class<? extends Papel> tipo) {
        papeis.removeIf(tipo::isInstance);
    }

    /** Promoção: troca todos os papéis atuais por um único papel exclusivo. */
    public void substituirPapeis(Papel novoPapel) {
        papeis.clear();
        papeis.add(novoPapel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nome).append(" [");
        boolean primeiro = true;
        for (Papel p : papeis) {
            if (!primeiro) sb.append(" + ");
            sb.append(p.getNome());
            primeiro = false;
        }
        return sb.append("]").toString();
    }
}