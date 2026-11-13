public class Economica implements Entrega {
    private final float tarifaFixa;
    private final float valorPorKm;
    private final float percentualDesconto;
    private final int prazoBaseDias;
    private final float kmPorDia;
    private final int diasAdicionais;

    public Economica(float tarifaFixa, float valorPorKm, float percentualDesconto,
                     int prazoBaseDias, float kmPorDia, int diasAdicionais) {
        this.tarifaFixa = Convencional.naoNegativo(tarifaFixa, "tarifaFixa");
        this.valorPorKm = Convencional.naoNegativo(valorPorKm, "valorPorKm");
        if (!Float.isFinite(percentualDesconto) || percentualDesconto < 0 || percentualDesconto > 100)
            throw new IllegalArgumentException("percentualDesconto deve estar entre 0 e 100");
        this.percentualDesconto = percentualDesconto;
        this.prazoBaseDias = Convencional.prazoValido(prazoBaseDias);
        this.kmPorDia = Convencional.positivo(kmPorDia, "kmPorDia");
        if (diasAdicionais <= 0) throw new IllegalArgumentException("diasAdicionais deve ser positivo");
        this.diasAdicionais = diasAdicionais;
    }

    @Override
    public float calcularFrete(Pedido pedido) {
        Convencional.validarPedido(pedido);
        float base = tarifaFixa + valorPorKm * pedido.getDistancia();
        return base * (1 - percentualDesconto / 100f);
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        Convencional.validarPedido(pedido);
        return prazoBaseDias + (int) Math.ceil(pedido.getDistancia() / kmPorDia) + diasAdicionais;
    }
}
