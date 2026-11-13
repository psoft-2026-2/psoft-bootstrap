import java.util.HashMap;
import java.util.Map;

public class Central {
    
    private static Central instance = null;
    private  Map<Long, Pedido> pedidos;
    private long proximoId;

    private Central() {
        this.pedidos = new HashMap<>();
        this.proximoId = 1L;
    }

    public static Central getInstance() {
        if(instance == null){
            instance = new Central();
        }
        return instance;
        
    }
    
    public  Long adicionarPedido(String origem, String destino, float peso) {
        long id = proximoId;

        Pedido pedido = new Pedido(id, peso, origem, destino);

        pedidos.put(id, pedido);
        proximoId++;

        return id;
    }

    public void setModalidadeEntregaPedido(Long id, ModalidadeEntrega modalidade) {
        obterPedido(id).setModalidade(modalidade);
    }

    public void despacharPedido(Long id) {
        obterPedido(id).despachar();
    }

    public String acompanhar(Long id) {
        return obterPedido(id).relatorio();
    }


    private Pedido obterPedido(Long id) {
        Pedido pedido = pedidos.get(id);
        if (pedido == null) throw new IllegalArgumentException("Pedido não encontrado: " + id);
        return pedido;
    }
}
