import java.util.LinkedList;

public class PessoaController {
    private LinkedList<Pessoa> pessoas;

    public PessoaController() {
        this.pessoas = new LinkedList<Pessoa>();
    }
    public PessoaController(LinkedList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public boolean createPessoa(String nome,int idade, CPF cpf){
        if (nome == null || cpf == null || !cpf.validaCPF()) {
            return false;
        }
        if (findPessoa(cpf) != null) {
            return false;
        }
        Pessoa pessoa = new Pessoa(nome, idade, cpf);
        this.pessoas.add(pessoa);
        return true;
    }

    public boolean updatePessoaIdade(CPF cpf){
        Pessoa pessoa = findPessoa(cpf);
        if (pessoa == null) {
            return false;
        }
        pessoa.setIdade(pessoa.getIdade() + 1);
        return true;
    }

    public boolean updatePessoaFuncao(CPF cpf, Funcao funcao){
        Pessoa pessoa = findPessoa(cpf);
        if (pessoa == null || funcao == null) {
            return false;
        }
        pessoa.setFuncao(funcao);
        return true;
    }
    
    public boolean updatePessoaProfissao(CPF cpf, String profissao){
        Pessoa pessoa = findPessoa(cpf);
        if (pessoa == null || profissao == null) {
            return false;
        }
        pessoa.setProfissao(profissao);
        return true;
    }
    public boolean addEndereco(CPF cpf,Endereco endereco){
        Pessoa pessoa = findPessoa(cpf);
        if (pessoa == null || endereco == null) {
            return false;
        }
        pessoa.addEndereco(endereco);
        return true;
    }
    public boolean deletePessoa(CPF cpf){
        Pessoa pessoa = findPessoa(cpf);
        if (pessoa == null) {
            return false;
        }
        this.pessoas.remove(pessoa);
        return true;
    }

    private Pessoa findPessoa(CPF cpf) {
        if (cpf == null) {
            return null;
        }
        for (Pessoa pessoa : this.pessoas) {
            String cpfPessoa = pessoa.getCpfUser().getCPF();
            if (cpfPessoa.equals(cpf.getCPF())) {
                return pessoa;
            }
        }
        return null;
    }
}
