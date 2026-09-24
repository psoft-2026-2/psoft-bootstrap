public class Cliente {
    private final int idCliente;
    private String perfil;

    public Cliente(int idCliente, String perfil) {
        this.idCliente = idCliente;
        this.perfil = perfil;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}
