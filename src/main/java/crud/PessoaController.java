package crud;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class PessoaController{

    private Map<Cpf, Pessoa> pessoas = new HashMap<>();

    public PessoaController(){}

    public Pessoa adicionar(Pessoa pessoa){
        if (pessoas.containsKey(pessoa.getCpf())){
            throw new IllegalArgumentException("Pessoas já existe no sistema!");
        }

        pessoas.put(pessoa.getCpf(), pessoa);
        return pessoa;
    }

    public void remover(Pessoa pessoa){
        if (!pessoas.containsKey(pessoa.getCpf())){
            throw new IllegalArgumentException("Pessoa não encontrada no sistema! Não há como remover o cadastro");
        }

        pessoas.remove(pessoa.getCpf());
    }
    
    public void update(Cpf cpf, List<Telefone> telefones, int idade, String profissao){
        if (!pessoas.containsKey(cpf)){
            throw new IllegalArgumentException("Pessoa não encontrada no sistema! Não há como remover o cadastro");
        }

        Pessoa pessoa = pessoas.get(cpf);
        
        pessoa.setIdade(idade);
        pessoa.setProfissao(profissao);
        pessoa.setTelefones(telefones);
    }
}