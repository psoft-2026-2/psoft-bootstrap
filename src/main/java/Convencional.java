public class Convencional implements Entrega {
    private final float tarifaFixa;
    private final float valorPorKm;
    private final int prazoBaseDias;
    private final float kmPorDia;

    public Convencional(float tarifaFixa, float valorPorKm, int prazoBaseDias, float kmPorDia) {
        this.tarifaFixa = naoNegativo(tarifaFixa, "tarifaFixa");
        this.valorPorKm = naoNegativo(valorPorKm, "valorPorKm");
        this.prazoBaseDias = prazoValido(prazoBaseDias);
        this.kmPorDia = positivo(kmPorDia, "kmPorDia");
    }

    @Override
    public float calcularFrete(Pedido pedido) {
        validarPedido(pedido);
        return tarifaFixa + valorPorKm * pedido.getDistancia();
    }

    @Override
    public int calcularPrazo(Pedido pedido) {
        validarPedido(pedido);
        return prazoBaseDias + (int) Math.ceil(pedido.getDistancia() / kmPorDia);
    }

    static float naoNegativo(float valor, String nome) {
        if (!Float.isFinite(valor) || valor < 0) throw new IllegalArgumentException(nome + " deve ser finito e nao negativo");
        return valor;
    }

    static float positivo(float valor, String nome) {
        if (!Float.isFinite(valor) || valor <= 0) throw new IllegalArgumentException(nome + " deve ser finito e positivo");
        return valor;
    }

    static int prazoValido(int valor) {
        if (valor < 1) throw new IllegalArgumentException("prazoBaseDias deve ser maior ou igual a 1");
        return valor;
    }

    static void validarPedido(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("pedido nao pode ser nulo");
    }
}
