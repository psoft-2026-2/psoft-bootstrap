public class Membro {
    private String nome;
    private final String cpf;
    private final int id;
    private Cargo cargo;

    public Membro(String nome, String cpf, int id, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void executaFuncao() {
        cargo.executaFuncao();
    }

    public Cargo promocao() {
        cargo = cargo.promocao();
        return cargo;
    }
}
