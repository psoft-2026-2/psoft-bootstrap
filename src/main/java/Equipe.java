import java.util.List;
import java.util.ArrayList;

public class Equipe {
    
    private List<Pessoa> devs;
    private List<Sprint> sprints;
    private Pessoa gerente;
    private Produto produto;

    public Equipe(Pessoa gerente){
        this.gerente = gerente;
        this.devs = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public boolean adicionarDesenvolvedor(Pessoa desenvolvedor){
        return this.devs.add(desenvolvedor);
    }

    public boolean removeDev(Pessoa desenvolvedor){
        return this.devs.remove(desenvolvedor);
    }

    public void criaSprint(String data, Pessoa lider){
        this.sprints.add(new Sprint(data, lider));
    }

    public List<Pessoa> getDevs() {
        return devs;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String listaSprints(){
        String out = "";

        for(int i = 0; i < this.sprints.size(); i++){
            out += "[" + i + "] " + this.sprints.get(i).toString() + "\n";
        }
        return out;
    }

    @Override
    public String toString() {
        return "Equipe [devs=" + devs + ", gerente=" + gerente + ", produto=" + produto + "]";
    }
}
