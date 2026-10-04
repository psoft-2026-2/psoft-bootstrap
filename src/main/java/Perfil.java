public class Perfil {
    private String tipo;
    private double percentualDesconto;

    private Perfil(String tipo, double percentualDesconto) {
        this.tipo = tipo;
        this.percentualDesconto = percentualDesconto;
    }

    public static Perfil criarStandard() {
        return new Perfil("Standard", 0.0);
    }

    public static Perfil criarPremium() {
        return new Perfil("Premium", 0.05);
    }

    public String getTipo() {
        return tipo;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void mudarParaStandard() {
        this.tipo = "Standard";
        this.percentualDesconto = 0.0;
    }

    public void mudarParaPremium() {
        this.tipo = "Premium";
        this.percentualDesconto = 0.05;
    }
}