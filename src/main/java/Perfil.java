public class Perfil {
    private String tipo;

    
    public Perfil(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double desconto() {
        if (tipo.equals("Premium"))
            return 0.95;
        return 1.0;
    }
}
