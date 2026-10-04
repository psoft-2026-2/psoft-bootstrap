import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String perfil;
    private List<Venda> compras;

    public Cliente() {
        this.compras = new ArrayList<>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public List<Venda> listarCompras() {
        return new ArrayList<>(compras);
    }

    void adicionarCompra(Venda venda) {
        if (venda == null) {
            return;
        }
        if (!compras.contains(venda)) {
            compras.add(venda);
        }
    }

    void removerCompra(Venda venda) {
        compras.remove(venda);
    }

    public String toString() {
        return "Cliente{cpf='" + cpf + "', perfil='" + perfil + "'}";
    }
}
