public class Cliente {
    private final String nome;
    private final String cpf;
    private final String endereco;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = textoValido(nome, "nome");
        this.cpf = textoValido(cpf, "cpf");
        this.endereco = textoValido(endereco, "endereco");
    }

    private static String textoValido(String valor, String nome) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(nome + " nao pode ser vazio");
        return valor;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
}
