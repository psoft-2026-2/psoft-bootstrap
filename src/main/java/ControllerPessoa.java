import java.util.List;
import java.util.ArrayList;

public class ControllerPessoa {
    
    private List<Pessoa> pessoas;

    public ControllerPessoa() {
        this.pessoas = new ArrayList<>();
    }

    private Pessoa recuperaPessoa(CPF cpf) {
        for (Pessoa p: pessoas) {
            if (p.getCpf() == cpf) {
                return p;
            }
        }    
        return null;
    }

    public String adicionarPessoa(String nome, int idade, CPF cpf, String telefone, String profissao, Papel papel) {
        Pessoa pessoaNova = new Pessoa(nome, idade, cpf, telefone, profissao, papel);
        if (recuperaPessoa(pessoaNova.getCpf()) != null) {
            this.pessoas.add(pessoaNova);
            return "Pessoa nova adicionada!";
        }
        return "Pessoa já está cadastrada!";
    }

    public String removerPessoa(CPF cpf) {
        Pessoa alvo = recuperaPessoa(cpf);
        if (alvo != null) {
            pessoas.remove(alvo);
            return "Pessoa removida";
        }
        return "Não existem cadastrados com esse CPF";
    }

    public String buscarPessoa(CPF cpf) {
        Pessoa pessoa = recuperaPessoa(cpf);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            return pessoa.toString();
        }
        return "Não existem cadastrados com esse CPF";
    }

    public List<String> filtrarPorProfissao(String profissao) {
        List<String> resultado = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getProfissao().equals(profissao)) {
                resultado.add(p.getNome() + " | " + p.getCpf().toString());
            }
        }
        return resultado;
    }

    public void atualizarDados(CPF cpf, int idadeNova, String telefoneNovo, String profissaoNova) {
        Pessoa pessoa = recuperaPessoa(cpf);
        if (pessoa != null) {
            if (idadeNova != 0) {
                pessoa.setIdade(idadeNova);
            }    
            if (telefoneNovo != null) {
                pessoa.setTelefone(telefoneNovo);
            }
            if (profissaoNova != null) {
                pessoa.setProfissao(profissaoNova);
            }
        }
    }

    public String adicionarEndereco(CPF cpf, Endereco endereco) {
        Pessoa pessoa = recuperaPessoa(cpf);
        if (pessoa != null) {
            if (pessoa.buscarEndereco(endereco) == null) {
                pessoa.adicionaEndereco(endereco);
                return "Endereco adicionado!";
            }
        }
        return "Endereco já associado a essa pessoa";
    }

    public String removerEndereco(CPF cpf, Endereco endereco) {
        Pessoa pessoa = recuperaPessoa(cpf);
        if (pessoa != null) {
            if (pessoa.buscarEndereco(endereco) != null) {
                pessoa.removeEndereco(endereco);
                return "Endereco removido!";
            }
        }
        return "Este endereco não está associado a essa pessoa";
    }

    public List<String> listarEnderecos(CPF cpf) {
        List<String> listaFinal = new ArrayList<>();
        Pessoa pessoa = recuperaPessoa(cpf);
        
        if (pessoa != null) {
            List<Endereco> ends = pessoa.getEnderecos();
            
            for (Endereco e: ends) {
                listaFinal.add(e.toString());
            }
        }
        
        return listaFinal;
    }
}
