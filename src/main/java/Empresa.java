import java.util.ArrayList;

public class Empresa {
    private ArrayList<Pessoa> funcionarios;
    private ArrayList<Produto> produtos;
    private ProductOwner productOwner;
    private static int proximoIdProduto = 0;

    public void adicionaFuncionario(String cpf, String nome) {
        if (cpfExisteNoSistema(cpf)) return; 
        Funcao funcao = new Desenvolvedor(20, 80);
        Pessoa funcionario = new Pessoa(cpf, nome, funcao);
        funcionarios.add(funcionario);
    }

    public void promoveParaGerente(String cpf) {
        if (!cpfExisteNoSistema(cpf)) return;
        Funcao funcao = new Gerente(40, 80);
        getFuncionario(cpf).setFuncao(funcao);
    }

    public void adicionaProduto() {}

    public void setProductOwner() {}

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    private Pessoa getFuncionario(String cpf) {
        for (Pessoa f : funcionarios) {
            if (f.getCpf().equals(cpf)) return f;
        }
        return null; 
    }

    private boolean cpfExisteNoSistema(String cpf) {
        for (Pessoa f : funcionarios) {
            if (f.getCpf().equals(cpf)) return true;
        }
        return false;
    }
}