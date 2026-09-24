public class Produto {

    private static int proximoId = 1;

    private int id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(String nome, String descricao, double preco) {

        if (preco < 0) {
            throw new IllegalArgumentException(
                    "O preço não pode ser negativo."
            );
        }

        this.id = proximoId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public int getId(){
        return this.id;
    }
}