package atividade05;

import java.util.ArrayList;
import java.util.List;

public class Central {
    private List<Pedido> pedidos;

    public Central() {
        this.pedidos = new  ArrayList<>(); 
    } 

    public void adicionarPedido(Pedido p){
        pedidos.add(p); 
        Logger.getInstancia().registrar("Novo pedido registrado com sucesso para: " + p.getCliente());
    }

    public void modificarEntrega(Pedido p, EstrategiaEntrega novaEntrega) {
        p.setModalidade(novaEntrega);
        Logger.getInstancia().registrar("Modalidade de entrega modificada para o pedido de: " + p.getCliente());
    }
    
    public double calcularEntrega(Pedido p) {
        double valor = p.calcularCustoTotal();
        Logger.getInstancia().registrar("Cálculo de entrega realizado para " + p.getCliente() + ": R$ " + valor);
        return valor;
    }
    public EstrategiaEntrega mostraEntrega(Pedido p){
        return  p.getModalidade(); 
    }

    public void processarEntregas() {
        Logger.getInstancia().registrar("Iniciando processamento das entregas na Central...");
        for (Pedido p : pedidos) {
            double custo = p.calcularCustoTotal();
            int prazo = p.calculaPrazoEstimato();
            String resumo = String.format("Pedido [%s] -> Custo: R$ %.2f | Prazo: %d dias",
                    p.getCliente(), custo, prazo);
            Logger.getInstancia().registrar(resumo);
        }
    }
}
