package atv2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private Funcionario productOwner;
    private List<Time> times = new ArrayList<>();

    public void adicionarTime(Time t) { times.add(t); }

    public void promoverAGerente(Funcionario f, Time t) {
        t.removerDesenvolvedor(f);
        f.promover(new PapelGerente());
        t.setGerente(f);
    }

    public void promoverAProductOwner(Funcionario f) {
        f.promover(new PapelProductOwner());
        this.productOwner = f;
    }

    public Funcionario getProductOwner() { return productOwner; }
}