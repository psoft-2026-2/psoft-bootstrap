public class Funcionario {
    private String nome;
    private String cpf;
    private Papel papelAtual;

    public Funcionario(String nome, String cpf, Papel papelInicial) {
        this.nome = nome;
        this.cpf = cpf;
        this.papelAtual = papelInicial;
    }

    public void setPapel(Papel novoPapel) {
        this.papelAtual = novoPapel;
    }

    public Papel getPapel() {
        return papelAtual;
    }

    public void realizarTrabalho() {
        papelAtual.realizarTrabalho();
    }
}