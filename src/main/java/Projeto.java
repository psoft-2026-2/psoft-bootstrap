import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String idProjeto;
    private Time time;
    private String descricao;
    private String status;
    private List<Sprint> sprints;

    public Projeto(String idProjeto, Funcionario gerente, String descricao){
        this.idProjeto = idProjeto;
        this.time = new Time(gerente);
        this.descricao = descricao; 
        this.sprints = new ArrayList<>();
        this.status = "Em desenvolvimento!";     
    }

    public void incluirDesenvolvedor(Funcionario dev){
        time.addDesenvolvedor(dev);
    }

    public void removerDesenvolvedor(Funcionario dev){
        time.removerDesenvolvedor(dev);
    }

    public void criarSprint(Funcionario dev, String descricao){
        if(time.getDesenvolvedores().contains(dev))
            sprints.add(new Sprint(dev, descricao));
        else throw new IllegalArgumentException("Desenvolvedor não pertence ao time de desenvolvedores.");
    }

    public List<Sprint> getSprints(){
        return this.sprints;
    }

    public Time getTime(){
        return this.time;
    }

    public void entregarProjeto(){
        this.status = "Entregue!";
    }

    @Override
    public String toString() {
        return "idProjeto: " + this.idProjeto + "\n" +
                "Descrição: " +  this.descricao + "\n" +
                "Status: " + this.status;
    }

}
