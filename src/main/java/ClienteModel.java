import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
    private String nome;
    private String cpf;
    private Pagamento pagamentoAtual;
    private List<Pagamento> historicoPagamentos;
    private boolean assinaturaPremium;
    
    public ClienteModel(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.pagamentoAtual = new Pagamento();
        this.historicoPagamentos = new ArrayList<>();
        this.assinaturaPremium = false;
    }

    public void pagar(String formaPagamento){
        if (assinaturaPremium) pagamentoAtual.descontoPremium();
        this.pagamentoAtual.finalizar();
        historicoPagamentos.add(pagamentoAtual);
        this.pagamentoAtual = new Pagamento();
        
    }

    public void mudarAssinatura(){
        this.assinaturaPremium =!assinaturaPremium;
    }

    public void addProdutoPagamento(String id, String nome, float valor){
        this.pagamentoAtual.addItem(id, nome, valor);
    }

    public void removeProdutoPagamento(String id){
        this.pagamentoAtual.removeItem(id);
    }
}