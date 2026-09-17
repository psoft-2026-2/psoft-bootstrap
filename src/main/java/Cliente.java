import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private List<Cartao> cartoes;

    public Cliente(String cpf, String telefone, String nome, Profissao profissao) {
        super(cpf, telefone, nome, profissao);
        this.cartoes = new ArrayList<>();
    }

    public void adicionarCartao(Cartao cartao) {
        cartoes.add(cartao);
    }

    public void removerCartao(Cartao cartao) {
        cartoes.remove(cartao);
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }
}