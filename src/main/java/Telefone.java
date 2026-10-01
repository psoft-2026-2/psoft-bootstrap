public class Telefone implements Contato {
    private String numero;
    private String prefixo;
    private String ddd;

    public Telefone(String numero, String prefixo, String ddd) {
        this.numero = numero;
        this.prefixo = prefixo;
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public boolean comunicar() {
        System.out.println(
            "Ligando para: +" + prefixo + " (" + ddd + ") " + numero
        );
        return true;
    }
}