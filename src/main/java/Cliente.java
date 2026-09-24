public class Cliente {
    private String id;
    private String nome;
    private TipoAssinatura tipoAssinatura;

    public Cliente(String id, String nome, TipoAssinatura tipoAssinatura) {
        this.id = id;
        this.nome = nome;
        this.tipoAssinatura = tipoAssinatura;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoAssinatura getTipoAssinatura() {
        return tipoAssinatura;
    }

    public double getPercentualDescontoAssinatura() {
        return tipoAssinatura.getPercentualDesconto();
    }
}