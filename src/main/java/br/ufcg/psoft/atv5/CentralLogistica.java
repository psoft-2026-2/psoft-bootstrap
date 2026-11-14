package br.ufcg.psoft.atv5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Singleton: existe uma única central de logística durante a execução. */
public class CentralLogistica {
    private static CentralLogistica instancia;
    private final List<Pedido> pedidos;

    private CentralLogistica() {
        this.pedidos = new ArrayList<>();
    }

    public static synchronized CentralLogistica getInstancia() {
        if (instancia == null) {
            instancia = new CentralLogistica();
        }
        return instancia;
    }

    public synchronized void registrarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        pedidos.add(pedido);
    }

    /** Exibe a situação de todos os pedidos registrados. */
    public synchronized void acompanharPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido p = pedidos.get(i);
            System.out.printf("Pedido #%d | Cliente: %s | Destino: %s | Modalidade: %s | "
                            + "Custo: R$ %.2f | Prazo: %.1f dia(s) | Situação: %s%n",
                    i + 1,
                    p.getCliente().getNome(),
                    p.getDestino(),
                    p.getModalidade().getClass().getSimpleName(),
                    p.calcularCusto(),
                    p.calcularPrazo(),
                    p.isDespachado() ? "DESPACHADO" : "AGUARDANDO DESPACHO");
        }
    }

    public synchronized List<Pedido> getPedidos() {
        return Collections.unmodifiableList(new ArrayList<>(pedidos));
    }
}
