public class Profissao {

    private String nome;
    private String cargo;
    private float salario;

    public Profissao(String nome, String cargo, float salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public String cargo(){
        return this.cargo;
    }

    public void setCargo(String novoCargo){
        this.cargo = novoCargo;
    }

    public float getSalario(){
        return this.salario;
    }

    public void setSalario(float novoSal){
        this.salario = novoSal;
    }

}