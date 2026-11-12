import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String cpf;
    private String nome;
    private Entrega entrega;
    private StatusEnum status;
    private String origem;
    private String destino;
    private Double distancia;
    private Double peso;
    private Integer id;
    private List<Produto> produtos; 

    public Pedido(String cpf, String nome, String origem, String destino, Double distancia, Double peso, Integer id, Entrega entrega) {
        this.cpf = cpf;
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.peso = peso;
        this.id = id;
        this.entrega = entrega;
        this.status = StatusEnum.PENDENTE;
        this.produtos = new ArrayList<>();
    }

    private void verificarSePodeAlterar() {
        if (this.status != StatusEnum.PENDENTE) {
            throw new IllegalStateException("A modalidade não pode ser alterada porque o pedido já foi despachado.");
        }
    }

    public void setEntregaConv() {
        verificarSePodeAlterar();
        this.entrega = new Convencional();
    }

    public void setEntregaExp() {
        verificarSePodeAlterar();
        this.entrega = new Expressa();
    }

    public void setEntregaEco() {
        verificarSePodeAlterar();
        this.entrega = new Economica();
    }

    public Double calcularCustoTotal() {
        return entrega.calcularCusto(this.distancia, this.peso);
    }

    public Integer calcularPrazoEstimado() {
        return entrega.estimarPrazo(this.distancia);
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Integer idProduto) {
        this.produtos.removeIf(p -> p.getId().equals(idProduto));
    }

    public Integer getId() {
        return id; 
    }

    public StatusEnum getStatus() { 
        return status; 
    }

    public void setStatus(StatusEnum status) { 
        this.status = status; 
    }

    public Entrega getEntrega() { 
        return entrega; 
    }

    public List<Produto> getProdutos() { 
        return produtos; 
    }
}