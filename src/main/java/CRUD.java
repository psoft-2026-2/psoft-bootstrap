public class CRUD {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void addPessoa(String nome, Cpf cpf, int idade, String telefone, ArrayList<Endereco> enderecos, String profissao, Papel papel) {
        Pessoa pessoa = new Pessoa(nome, cpf, idade, telefone, enderecos, profissao, papel);
        this.pessoas.add(pessoa);
    }

    public Pessoa buscar(Cpf cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().getNumero().equals(cpf.getNumero())) {
                return pessoa;
            }
        }
        return null;
    }

    public void atualizarProfissao(Cpf cpf, String novaProfissao) {
        Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
            pessoa.setProfissao(novaProfissao);
        }
    }
    
    public void atualizarIdade(Cpf cpf, int novaIdade) {
        Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
            pessoa.setIdade(novaIdade);
        }
    }

    public void adicionarEndereco(Cpf cpf, String rua, String bairro, int numero, String cidade) {
        Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
            pessoa.addEndereco(rua, bairro, numero, cidade);
        }
    }

    public void atualizarTelefone(Cpf cpf, String novoTelefone) {
    Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
        pessoa.setTelefone(novoTelefone);
        }
    }

    public void atualizarPapel(Cpf cpf, Papel novoPapel) {
        Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
            pessoa.setPapel(novoPapel);
        }
    }

    public void removePessoa(Cpf cpf) {
        Pessoa pessoa = buscar(cpf);
        if (pessoa != null) {
            pessoas.remove(pessoa); 
        } 
    }       
}