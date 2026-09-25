import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private List<Venda> vendas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Mercado(){}

    public void novoCliente(String cpf, String nome, Perfil p){
        clientes.add(new Cliente(cpf, nome, p));
    }
    public List<Venda> getVendas() {
        return vendas;
    }

    public Venda iniciarVenda(String cpf) {
        Cliente cliente = buscaCliente(cpf);   // acha o cliente na própria lista
        Venda venda = new Venda(cliente);
        vendas.add(venda);
        return venda;
    }

    private Cliente buscaCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        Produto arroz  = new Produto("Arroz", 25.0);
        Produto feijao = new Produto("Feijão", 8.0);

        mercado.novoCliente("123.456.789", "nome1", Perfil.PREMIUM);
        mercado.novoCliente("987.654.321", "nome2", Perfil.STANDARD);

        //Venda para o nome1
        Venda venda1 = mercado.iniciarVenda("123.456.789"); //tem desconto de premium

        venda1.adicionaItem(2, arroz);
        venda1.adicionaItem(100, feijao); //tem desconto de lote também

        System.out.println("Total: " + venda1.calculaTotal());
        venda1.fazerPagamento(new PagamentoCartao(12345678));

        System.out.println(venda1);

        //Venda pra o nome2
        Venda venda2 = mercado.iniciarVenda("987.654.321"); //nao tem desconto de premium, é standard

        venda2.adicionaItem(20, arroz);
        venda2.adicionaItem(1, feijao); //tem desconto de lote também

        System.out.println("Total: " + venda2.calculaTotal());
        venda2.fazerPagamento(new PagamentoDinheiro());

        System.out.println(venda2);

    }



}