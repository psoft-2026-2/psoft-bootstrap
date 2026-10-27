import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private int id;
    private int idUsuario;
    private Map<Integer, Integer> itens;
    private Usuario usuario;

    public Carrinho(int id, Usuario usuario) {
        this.id = id;
        this.idUsuario = usuario.getId();
        this.usuario = usuario;
        this.itens = new HashMap<>();
    }

    public void Add_Item(int id) {
        if (Produto.getProduto(id) == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        itens.put(id, itens.getOrDefault(id, 0) + 1);
    }

    public void Rem_Item(int id) {
        if (!itens.containsKey(id)) {
            return;
        }
        int quantidade = itens.get(id);
        if (quantidade <= 1) {
            itens.remove(id);
        } else {
            itens.put(id, quantidade - 1);
        }
    }

    public float Calc_Total() {
        float total = 0;
        for (Map.Entry<Integer, Integer> item : itens.entrySet()) {
            Produto produto = Produto.getProduto(item.getKey());
            int quantidade = item.getValue();
            total += produto.getPreco() * quantidade;
        }
        return total;
    }

    public float Calc_Desconto() {
        float total = Calc_Total();
        for (Map.Entry<Integer, Integer> item : itens.entrySet()) {
            Produto produto = Produto.getProduto(item.getKey());
            int quantidade = item.getValue();
            if (quantidade >= 20) {
                float valorItem = produto.getPreco() * quantidade;
                total -= valorItem * 0.10f;
            }
        }
        if (usuario.getAssinatura() == Assinatura.PREMIUN) {
            total *= 0.95f;
        }
        return total;
    }

    public Compra Gera_Compra() {
        float valor = Calc_Desconto();
        float desconto = Calc_Total() - valor;
        return new Compra(
            id,
            idUsuario,
            itens,
            valor,
            desconto
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
}