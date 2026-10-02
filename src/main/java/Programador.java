public class Programador {
    private String nome;
    private String cpf;
    private Papel papel;

    public Programador(String nome, String cpf, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.papel = papel;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Papel getPapel() { return papel; }

  
    void setPapel(Papel papel) { this.papel = papel; }

    public String promover(Papel novoPapel) {
        boolean devOuLider = papel instanceof Desenvolvedor || papel instanceof Lider;
        if (devOuLider && novoPapel instanceof Gerente
                || papel instanceof Gerente && novoPapel instanceof ProductOwner) {
            this.papel = novoPapel;
            return nome + " promovido(a) a " + novoPapel.getNome();
        }
        return "Promoção inválida ! ";
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ") - " + papel.getNome();
    }
}