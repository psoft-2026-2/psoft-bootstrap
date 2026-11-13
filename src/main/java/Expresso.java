public class Expresso implements Entrega {
    private final float tarifaFixa;
    private final float valorPorKm;
    private final float adicionalPrioridade;
    private final int prazoBaseDias;
    private final float kmPorDia;
    private final int reducaoDias;

    public Expresso(float tarifaFixa, float valorPorKm, float adicionalPrioridade,
                    int prazoBaseDias, float kmPorDia, int reducaoDias) {
        this.tarifaFixa = Convencional.naoNegativo(tarifaFixa, "tarifaFixa");
        this.valorPorKm = Convencional.naoNegativo(valorPorKm, "valorPorKm");
        this.adicionalPrioridade = Convencional.naoNegativo(adicionalPrioridade, "adicionalPrioridade");
        this.prazoBaseDias = Convencional.prazoValido(prazoBaseDias);
        this.kmPorDia = Convencional.positivo(kmPorDia, "kmPorDia");
        if (reducaoDias < 0) throw new IllegalArgumentException("reducaoDias nao pode ser negativa");
        this.reducaoDias = reducaoDias;
    }

    @Override
    public float calcularFrete(Pedido pedido) {
        Convencional.validarPedido(pedido);
        return tarifaFixa + valorPorKm * pedido.getDistancia() + adicionalPrioridade;
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        Convencional.validarPedido(pedido);
        int normal = prazoBaseDias + (int) Math.ceil(pedido.getDistancia() / kmPorDia);
        return Math.max(1, normal - reducaoDias);
    }
}
