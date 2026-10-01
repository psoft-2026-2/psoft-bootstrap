public class Funcionario {

    private String nome;
    private String cpf;
    private Papel papel;

    public Funcionario(String nome, String cpf, Papel papel) {
        this.nome = nome;
        this.cpf = cpf;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String novo) {
        this.cpf = novo;
    }

    public Papel getPapel() {
        return papel;
    }

    public void promoverPapel() {
        if (papel instanceof PapelDesenvolvedor) {
            papel = new PapelGerente();
        } else if (papel instanceof PapelGerente) {
            papel = new PapelProductOwner();
        }
    }
}
