public class Sprint {
    private Funcionario lider;
    private String descricao;

    public Sprint(Funcionario funcionario, String descricao){
        this.lider = funcionario;
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public Funcionario getLider(){
        return this.lider;
    }

    @Override 
    public String toString(){
        return "Líder: " + this.lider.getNome() + "\n" +
                "Descrição: " + this.descricao; 
    }
}
