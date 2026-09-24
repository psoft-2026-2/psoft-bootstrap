public class Cliente {
    private String tipo;
    private String cpf;
    private String nome;

    public Cliente(String tipo, String cpf, String nome) {
        this.tipo = tipo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void updateTipo(String tipo) {
        this.tipo = tipo;
    }
}
