package atv2;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private String nome;
    private Papel papelPrincipal;
    private List<Papel> papeisTemporarios = new ArrayList<>();

    public Funcionario(String nome) {
        this.nome = nome;
        this.papelPrincipal = new PapelDesenvolvedor();
    }

    public void trabalhar() {
        papelPrincipal.executar();
        papeisTemporarios.forEach(Papel::executar);
    }

    public void promover(Papel novo) {
        this.papelPrincipal = novo;
        this.papeisTemporarios.clear();
    }

    public void atribuirPapelTemporario(Papel p) { papeisTemporarios.add(p); }
    public void encerrarPapelTemporario(Papel p) { papeisTemporarios.remove(p); }

    public String getNome() { return nome; }
    public Papel getPapelPrincipal() { return papelPrincipal; }
}