public class Cliente {

  private String nome;
  private String cpf;
  private Integer idade;
  private String telefone;
  private String endereco;
  private Perfil perfil;

  public Cliente(String nome, String cpf, Integer idade, String telefone, String endereco) {
    this.nome = nome;
    this.cpf = cpf;
    this.idade = idade;
    this.telefone = telefone;
    this.endereco = endereco;
    this.perfil = Perfil.STANDARD;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public Integer getIdade() {
    return idade;
  }

  public String getEndereco() {
    return endereco;
  }
  
  public Perfil getPerfil() {
    return perfil;
  }

  public String getTelefone() {
    String ddd = telefone.substring(0, 2);
    String numero = telefone.substring(2);
    return "(" + ddd + ") " + numero;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public void tornarPremium() {
    this.perfil = Perfil.PREMIUM;
  }

  public String toString() {
    return "nome: " + nome +
            "\ncpf ='" + cpf +
            "\nidade=" + idade +
            "\ntelefone: " + getTelefone() +
            "\nendereco: " + endereco +
            "\nperfil: " + perfil;
  }
}
