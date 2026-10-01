import java.util.ArrayList;
import java.util.List;

public class Time {
    private List<Funcionario> devs;
    private Funcionario gerente;
    private Funcionario prodOwner;
    private Funcionario liderAtual;
    private ProdSoftware prodSoftware;

    public Time(ProdSoftware prodSoftware) {
        this.prodSoftware = prodSoftware;
        this.devs = new ArrayList<>();
    }

    public void addDev(Funcionario dev) {
        this.devs.add(dev);
    }

    public void setLider(String nome) {
        for (Funcionario f : devs) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                this.liderAtual = f;
                return;
            }
        }
    }

    public void setGerente(String nome) {
        if (this.liderAtual != null && this.liderAtual.getNome().equalsIgnoreCase(nome)) {
            this.liderAtual.alteraCargoGerente();
            this.gerente = this.liderAtual;
            return;
        }

        for (Funcionario f : devs) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                f.alteraCargoGerente();
                this.gerente = f;
                return;
            }
        }
    }

    public void setProdOwner(String nome) {
        if (this.gerente != null && this.gerente.getNome().equalsIgnoreCase(nome)) {
            this.gerente.alteraCargoProd();
            this.prodOwner = this.gerente;
        }
    }

    public Funcionario getLiderAtual() {
        return liderAtual;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public Funcionario getProdOwner() {
        return prodOwner;
    }

    public List<Funcionario> getDevs() {
        return devs;
    }

    public ProdSoftware getProdSoftware() {
        return prodSoftware;
    }
}
