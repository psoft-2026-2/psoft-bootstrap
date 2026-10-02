import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Pessoa> funcionarios;
    private List<Produto> produtos;
    private List<Equipe> equipes;
    private Pessoa projectOwner;

    public Empresa(){
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.equipes = new ArrayList<>();
    }

    public boolean adicionaFuncionario(String nome){
        return this.funcionarios.add(new Pessoa(nome));
    }

    public boolean adicionaFuncionario(String nome, String cargo){
        Pessoa novoFuncionario = new Pessoa(nome);
        novoFuncionario.setCargo(cargo);
        return this.funcionarios.add(novoFuncionario);
    }
    
    public boolean removeFuncionario(String nome){
        Pessoa remover = null;
        for(Pessoa funcionario: this.funcionarios){
            if(funcionario.getNome().equals(nome))
                remover = funcionario;
        }
        return this.funcionarios.remove(remover);
    }

    public void adicionaProduto(String nome){
        this.produtos.add(new Produto(nome));
    }

    public void removeProduto(String nome){
        Produto remover = null;
        for(Produto produto: this.produtos){
            if(produto.getNome().equals(nome))
                remover = produto;
        }
        this.produtos.remove(remover);
    }

    public void criarEquipe(Pessoa gerente){
        this.equipes.add(new Equipe(gerente));
    }

    public boolean removeEquipe(int id){
        if(this.equipes.remove(id) == null)
            return false;
        return true;
    }

    public void setPO(Pessoa pessoa){
        this.projectOwner = pessoa;
    }

    public Pessoa getPO(){
        return this.projectOwner;
    }

    public String listaFuncionarios(){
        String out = "";

        for(int i = 0; i < this.funcionarios.size(); i++)
            out += "[" + i + "]" + this.funcionarios.get(i).toString() + "\n";
        
        return out;
    }

    public String listaProdutos(){
        String out = "";

        for(int i = 0; i < this.produtos.size(); i++)
            out += "[" + i + "]" + this.produtos.get(i).toString() + "\n";
        
        return out;
    }

    public String listaEquipes(){
        String out = "";

        for(int i = 0; i < this.equipes.size(); i++)
            out += "[" + i + "]" + this.equipes.get(i).toString() + "\n";
        
        return out;
    }
}
