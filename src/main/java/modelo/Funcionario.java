package modelo;

import funcao.Dev;
import funcao.Funcao;
import funcao.Gerente;
import funcao.Lider;
import funcao.ProductOwner;

public class Funcionario {
    private final String id;
    private String nome;
    private Funcao funcaoAtual;

    public Funcionario(String id, String nome, Funcao funcaoInicial) {
        this.id = id;
        this.nome = nome;
        this.funcaoAtual = funcaoInicial;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcao getFuncaoAtual() {
        return funcaoAtual;
    }

    public void setFuncaoAtual(Funcao novaFuncao) {
        this.funcaoAtual = novaFuncao;
    }

    public boolean ehDev() {
        return funcaoAtual instanceof Dev || funcaoAtual instanceof Lider;
    }

    public boolean ehGerente() {
        return funcaoAtual instanceof Gerente;
    }

    public boolean ehProductOwner() {
        return funcaoAtual instanceof ProductOwner;
    }

    public boolean ehLider() {
        return funcaoAtual instanceof Lider;
    }

    public void promoverAGerente() {
        if (ehDev()) {
            this.funcaoAtual = new Gerente();
        }
    }

    public void promoverAProductOwner() {
        if (ehGerente()) {
            this.funcaoAtual = new ProductOwner();
        }
    }

    public void assumirLideranca() {
        if (ehDev() && !ehLider()) {
            this.funcaoAtual = new Lider(new Dev());
        }
    }

    public void renunciarLideranca() {
        if (ehLider()) {
            this.funcaoAtual = new Dev();
        }
    }

    public void executarFuncao() {
        System.out.println(nome + " [" + funcaoAtual.getNome() + "]: executando função");
        funcaoAtual.executar();
    }
}