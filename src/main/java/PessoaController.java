import java.util.*;

public class PessoaController {
    private ArrayList<Pessoa> pessoas;

    public PessoaController(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String cadastrarPessoa(String nome, String cpf, String profissao, int idade, String papel){
        if(buscarPessoa(cpf) == null){
            Pessoa p = new Pessoa(cpf, idade, nome, papel, profissao);
            pessoas.add(p);
            return nome + " Cadastrado";
        }
        
        return nome + " ja existe!";
    }

    public String DeletarPessoa(String cpf){
        Pessoa p = buscarPessoa(cpf);
        if(p == null){
            pessoas.remove(p);
            return cpf + " DELETADO";
        }
        return cpf + " Não existe!";
    }

    public Pessoa buscarPessoa(String cpf){
        for (Pessoa p : pessoas){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }
    
}
