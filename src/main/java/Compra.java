import java.util.HashMap;
import java.util.Map;

public class Compra {
    private int id;
    private int idUsuario;
    private Map<Integer, Integer> itens;
    private float valor;
    private float desconto;

    public Compra(int id, int idUsuario, Map<Integer, Integer> itens, float valor, float desconto) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.itens = new HashMap<>(itens);
        this.valor = valor;
        this.desconto = desconto;
    }

    public Pagamento Gera_Pagamento() {
        return new Pagamento(
            id,
            idUsuario,
            valor,
            StatusPagamento.PROCESSANDO
        );
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Map<Integer, Integer> getItens() {
        return itens;
    }

    public float getValor() {
        return valor;
    }

    public float getDesconto() {
        return desconto;
    }
}