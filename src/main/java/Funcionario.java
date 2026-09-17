public class Funcionario extends Pessoa {

    private String funcao;

    public Funcionario(String funcao, String nome, int idade, String cpf, String telefone, Endereco endereco, Profissao profissao){
        super(nome, idade, cpf, telefone, endereco, profissao);
        this.funcao = funcao;
    }

    public String getFuncao(){
        return this.funcao;
    }

    public void setFuncao(String novaFuncao){
        this.funcao = novaFuncao;
    }
}