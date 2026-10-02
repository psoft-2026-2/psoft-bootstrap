public class Sprint {

    private String data;
    private Pessoa lider;
    private String descricao;

    public Sprint(String data, Pessoa lider){
        this.data = data;
        this.lider = lider;
    }

    public Sprint(String data, Pessoa lider, String descricao){
        this.data = data;
        this.lider = lider;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public Pessoa getLider() {
        return lider;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "Sprint do dia: " + this.data + ";\nLider: " + this.lider + "\nDescrição: " + this.descricao;
    }
}
