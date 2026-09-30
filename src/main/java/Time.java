package main.java;

import java.util.List;
import java.util.ArrayList;

public class Time {
    private ProductSoftware productSoftware;
    private List<Colaborador> colaboradores;

    public Time(ProductSoftware productSoftware) {
        this.productSoftware = productSoftware;
        this.colaboradores = new ArrayList<>();
    }

    public void receberMembros(List<Colaborador> novosMembros) {
        this.colaboradores.addAll(novosMembros);
    }

    public void adicionarMembro(Colaborador colaborador) {
        this.colaboradores.add(colaborador);
    }

    public ProductSoftware getProductSoftware() { return productSoftware; }
    public List<Colaborador> getColaboradores() { return colaboradores; }
}