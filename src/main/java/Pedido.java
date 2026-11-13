import java.util.Objects;

public class Pedido {
    private final int numero;
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final double pesoKg;
    private final double distanciaKm;

    private double custo;
    private int prazoEstimado;
    private StatusPedido status;
    private EstrategiaEntrega estrategia;

    public Pedido(int numero, Cliente cliente, Endereco origem, Endereco destino,
                  double pesoKg, double distanciaKm) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número do pedido deve ser positivo.");
        }
        this.numero = numero;
        this.cliente = Objects.requireNonNull(cliente, "O cliente é obrigatório");
        this.origem = Objects.requireNonNull(origem, "O endereço de origem é obrigatório");
        this.destino = Objects.requireNonNull(destino, "O endereço de destino é obrigatório");
        this.pesoKg = validarNaoNegativo(pesoKg, "O peso");
        this.distanciaKm = validarNaoNegativo(distanciaKm, "A distância");
        this.status = StatusPedido.REGISTRADO;
    }

    public Pedido(int numero, Cliente cliente, Endereco origem, Endereco destino,
                  double pesoKg, double distanciaKm, EstrategiaEntrega estrategia) {
        this(numero, cliente, origem, destino, pesoKg, distanciaKm);
        setEstrategia(estrategia);
    }

    public void setEstrategia(EstrategiaEntrega estrategia) {
        if (status != StatusPedido.REGISTRADO) {
            throw new IllegalStateException("A modalidade só pode ser alterada antes do despacho.");
        }
        EstrategiaEntrega novaEstrategia = Objects.requireNonNull(estrategia, "A estratégia é obrigatória");
        double novoCusto = validarCusto(novaEstrategia.calcularCusto(this));
        int novoPrazo = validarPrazo(novaEstrategia.calcularPrazo(this));

        this.estrategia = novaEstrategia;
        this.custo = novoCusto;
        this.prazoEstimado = novoPrazo;
    }

    public void setModalidadeEntrega(EstrategiaEntrega estrategia) {
        setEstrategia(estrategia);
    }

    public double calcularCusto() {
        custo = validarCusto(estrategiaObrigatoria().calcularCusto(this));
        return custo;
    }

    public int calcularPrazo() {
        prazoEstimado = validarPrazo(estrategiaObrigatoria().calcularPrazo(this));
        return prazoEstimado;
    }

    public void atualizarEstimativas() {
        EstrategiaEntrega estrategiaAtual = estrategiaObrigatoria();
        double novoCusto = validarCusto(estrategiaAtual.calcularCusto(this));
        int novoPrazo = validarPrazo(estrategiaAtual.calcularPrazo(this));
        custo = novoCusto;
        prazoEstimado = novoPrazo;
    }

    public void despachar() {
        estrategiaObrigatoria();
        if (status != StatusPedido.REGISTRADO) {
            throw new IllegalStateException("O pedido já foi despachado.");
        }
        status = StatusPedido.DESPACHADO;
    }

    public void iniciarTransporte() {
        exigirStatus(StatusPedido.DESPACHADO, "O pedido precisa ser despachado antes de entrar em transporte.");
        status = StatusPedido.EM_TRANSPORTE;
    }

    public void entregar() {
        exigirStatus(StatusPedido.EM_TRANSPORTE, "O pedido precisa estar em transporte para ser entregue.");
        status = StatusPedido.ENTREGUE;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getCusto() {
        estrategiaObrigatoria();
        return custo;
    }

    /** O prazo estimado é expresso em horas. */
    public int getPrazoEstimado() {
        estrategiaObrigatoria();
        return prazoEstimado;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public boolean isDespachado() {
        return status != StatusPedido.REGISTRADO;
    }

    public EstrategiaEntrega getEstrategia() {
        return estrategia;
    }

    private EstrategiaEntrega estrategiaObrigatoria() {
        if (estrategia == null) {
            throw new IllegalStateException("A modalidade de entrega ainda não foi selecionada.");
        }
        return estrategia;
    }

    private void exigirStatus(StatusPedido esperado, String mensagem) {
        if (status != esperado) {
            throw new IllegalStateException(mensagem);
        }
    }

    private static double validarNaoNegativo(double valor, String nome) {
        if (!Double.isFinite(valor) || valor < 0.0) {
            throw new IllegalArgumentException(nome + " deve ser um número não negativo.");
        }
        return valor;
    }

    private static double validarCusto(double valor) {
        if (!Double.isFinite(valor) || valor < 0.0) {
            throw new IllegalArgumentException("A estratégia retornou um custo inválido.");
        }
        return valor;
    }

    private static int validarPrazo(int prazo) {
        if (prazo < 0) {
            throw new IllegalArgumentException("A estratégia retornou um prazo inválido.");
        }
        return prazo;
    }
}
