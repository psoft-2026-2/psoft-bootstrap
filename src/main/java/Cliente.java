import java.util.ArrayList;

public class Cliente extends Pessoa {

    private ArrayList<String> carrinho;

    public Cliente(
            String nome,
            int idade,
            String cpf,
            String telefone,
            String profissao
    ) {
        super(nome, idade, cpf, telefone, profissao);

        this.carrinho = new ArrayList<>();
    }

    public ArrayList<String> getCarrinho() {
        return carrinho;
    }

    public void adicionarProduto(String produto) {
        carrinho.add(produto);
    }

    public void removerProduto(String produto) {
        carrinho.remove(produto);
    }
}