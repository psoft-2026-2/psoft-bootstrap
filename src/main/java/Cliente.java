package br.edu.ufcg.psoft.mercado;

public class Cliente {

    private String cpf;
    private String nome;
    private String assinatura;
    private static final double DESCONTO_STANDARD = 0.0;
    private static final double DESCONTO_PREMIUM = 0.05;
    public Cliente(String nome, String cpf, String assinatura) {
        validarAssinatura(assinatura);
        this.nome = nome;
        this.cpf = cpf;
        this.assinatura = assinatura;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String novaAssinatura) {
        validarAssinatura(novaAssinatura);
        this.assinatura = novaAssinatura;
    }

    public double getDescontoAssinatura() {
        if (assinatura.equalsIgnoreCase("premium")) {
            return DESCONTO_PREMIUM;
        }
        return DESCONTO_STANDARD;
    }

    private void validarAssinatura(String assinatura) {
        if (assinatura == null
                || !(assinatura.equalsIgnoreCase("standard") || assinatura.equalsIgnoreCase("premium"))) {
            throw new IllegalArgumentException("Assinatura deve ser 'standard' ou 'premium'.");
        }
    }
}