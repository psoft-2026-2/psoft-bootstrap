public class Pessoa{
  public String nome;
  public Integer idade;
  public String CPF;
  public String telefone;
  public String[] Endereco;
  public String Profissao; 

  
  public Pessoa(String nome, Int idade, String CPF, String telefone, String[] Endereco, String profissao){
      this.nome = nome;
      this.idade = idade;
      this.telefone = telefone;
      this.Endereco = Endereco;
      this.profissao = Profissao;
      this.CPF = CPF;
  }
  public  boolean Hashcode(){ 
        return ;
  }
  public string getString(){
      return "Nome: " + nome + ", Idade: " + idade+ ", CPF: " + CPF + ", endereço(s)" + "" + ", Profissao:" + Profissao +", Telefone" + telefone;
  }
  public  string getnome(){
      return this.nome;
  }
  public  integer getidade(){
      return this.nome;
  }

  public  string gettelefone(){
      return this.telefone;
  }

  public  string[] getendereco(){
      return this.nome;
  }

  public  string getcpf(){
      return this.CPF;
  }

  public  string getprofissao(){
      return this.Profissao;
  }
  public  Boolean Updatetelefone(String novotelefone){
    if(novotelefone.isString()){
      this.telefone = telefone;
      return true;
    }
    return false;
  }
  public  Boolean UpdateEndereco(String[] novoEndereco){
    if(novonome.isNull()){
      this.Endereco = novoEndereco;
      return true;
    }
    return false;
  }
  public  Boolean Updateidade(integer novaidade){
    if(novaidade> this.idade && novaidade<130){
      this.idade = novaidade;
      return true;
    }
    return false;
  }
  public  Boolean UpdateProfissao(String novaprofissao){
    if(novaprofissao.isString()){
          this.Profissao = novaprofissao;
          return true;
    }
    return false;
  }
}
