package entrega;

import modelo.Pedido;

public class Expressa implements Entrega {
    private String prioridade;
    public Expressa(String prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade não pode ser nula.");
        }
        String p = prioridade.trim().toUpperCase();
        if (!p.equals("ALTA") && !p.equals("NORMAL")) {
            throw new IllegalArgumentException("Prioridade inválida: use ALTA ou NORMAL.");
        }
        this.prioridade = p;
    }

    @Override
    public double calculaCusto(Pedido pedido) {
        final double valorPorKm = 2.5;
        double adicional = prioridade.equals("ALTA") ? 50.0 : 20.0;
        return valorPorKm * pedido.getDistancia() + adicional;
    }

    @Override
    public int calculaPrazo(Pedido pedido) {
        final double kmPorDia = 80.0;
        return (int) Math.ceil(pedido.getDistancia() / kmPorDia);
    }
}