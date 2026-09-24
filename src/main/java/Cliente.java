public class Cliente {
    private String cpf;
    private String tipo;

    public Cliente(String cpf, String tipo) {
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public boolean isPremium() {
        return "premium".equals(tipo);
    }

    public String getCpf() {
        return cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}