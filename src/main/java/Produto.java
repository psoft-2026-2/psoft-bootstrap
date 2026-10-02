public class Produto {
    private int id;
    private String descricao;
    private String status;
    
    public Produto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = "iniciado";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.status;
    }

    
}
