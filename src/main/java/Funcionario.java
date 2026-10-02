public class Funcionario {
    private String nome;
    private Papel papel;

    public Funcionario(String nome, Papel papel) {
        this.nome = nome;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public Papel getPapel() {
        return papel;
    }

    public void modificaPapel(Papel novoPapel) {
        this.papel = novoPapel;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n"+ this.papel;
    }

}