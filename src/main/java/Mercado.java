import java.util.Map;

public class Mercado {

    Map<String, Produto> p_list;
    Map<String, Cliente> c_list;


    public void adicionarProduto(Produto produto, String nome){
        p_list.put(nome, produto);
    }
    
    public void cadastro(Cliente cliente, String cpf){    
        c_list.put(cpf, cliente);
    }
    
    public void removerProduto(String nome){
        p_list.remove(nome);
    }
}
