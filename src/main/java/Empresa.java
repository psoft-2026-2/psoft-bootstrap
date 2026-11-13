import java.util.Hashtable;
import java.util.List;

public class Empresa {
   private Funcionario productOwner;
   private Hashtable<String, Funcionario> funcionarios;
   private Hashtable<String, Projeto> projetos;

    public Empresa(){
        this.funcionarios = new Hashtable<>();
        this.projetos = new Hashtable<>();
    }

    public void contratar(String nome, String cpf, float salario){
        funcionarios.put(cpf, new Funcionario(nome, cpf, salario));
    }
    
    public void demitir(String cpf){
        funcionarios.remove(cpf);
    }

    public void elejerProductOwner(String cpf){
        funcionarios.get(cpf).promoverAPO();
    }

    public void promover(String cpf){
        funcionarios.get(cpf).promoverAGerente();
    }

    public void darAumento(String cpf, float  valor){
        funcionarios.get(cpf).aumento(valor);
    }

    public void criarProjeto(String idProjeto, String cpf, String descricao){
        projetos.put(idProjeto, new Projeto(idProjeto, funcionarios.get(cpf), descricao));
    }

    public void addDesenvolvedorEmProjeto(String cpf, String idProjeto){
        projetos.get(idProjeto).incluirDesenvolvedor(funcionarios.get(cpf));
    }

    public void removerDesenvolvedorDeProjeto(String cpf, String idProjeto){
        projetos.get(idProjeto).removerDesenvolvedor(funcionarios.get(cpf));
    }

    public void excluirProjeto(String idProjeto){
        projetos.remove(idProjeto);
    }

    public void sprintsDeProjeto(String idProjeto){
        List<Sprint> sprints = projetos.get(idProjeto).getSprints();
        for (Sprint s : sprints) {
            System.out.println(s.toString());
        }
    }

    public void ListarTimeDeProjeto(String idProjeto){
        System.out.println(projetos.get(idProjeto).getTime().toString()); 
    }

    public void entregarProjeto(String idProject){
        projetos.get(idProject).entregarProjeto();
    }

    public void listarFuncionarios(){
        for(Funcionario funcionario : funcionarios.values())
            System.out.print(funcionario.toString());
    }

    public void listarProjetos(){
        for(Projeto funcionario : projetos.values())
            System.out.print(funcionario.toString());
    }
}
