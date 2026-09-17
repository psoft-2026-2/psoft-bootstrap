package modelo;

public class Funcionario extends Pessoa {
    private  String matricula;
    

    public Funcionario(String nome, String cpf, String telefone, String cargo, String matricula) {
        super(nome, cpf, telefone, cargo);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    } 
    
}
