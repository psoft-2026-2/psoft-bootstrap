package main.java;

import java.util.List;

public class ProductSoftware {
    private String nome;
    private String tipo;
    private List<String> historicoFuncionalidades;

    public ProductSoftware(String nome, String tipo, List<String> historicoFuncionalidades) {
        this.nome = nome;
        this.tipo = tipo;
        this.historicoFuncionalidades = historicoFuncionalidades;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public List<String> getHistoricoFuncionalidades() { return historicoFuncionalidades; }
}