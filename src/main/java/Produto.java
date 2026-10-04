public class Produto {
    private String nome;
    private String codigo;
    private float valor;

    public Produto(String nome, String codigo, float valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getValor() {
        return valor;
    }

}
