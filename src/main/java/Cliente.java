import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private List<Pedido> pedidos;
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public void setModalidade(Pedido pedido, ModalidadeEntrega modalidade) {
        pedido.setModalidade(modalidade);
    }
}
