package main.java;

import java.util.List;
import java.util.ArrayList;

public class Empresa {
    private String nome;
    private String cnpj;
    private List<Colaborador> productOwners;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.productOwners = new ArrayList<>();
    }

    public void adicionarProductOwner(Colaborador po) {
        this.productOwners.add(po);
    }

    public List<Colaborador> listarProductOwners() {
        return productOwners;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
}