import java.util.ArrayList;
import java.util.List;

/**
 * Time
 */
public class Time {
    private  int id; 
    private  Funcionario gerente; 
    private Produto produto; 
    private List<Funcionario> desenvolvedores;
    
    public Time(int id, Funcionario gerente) {
        this.id = id;
        this.gerente = gerente;
        this.desenvolvedores = new  ArrayList<>(); 
    }

    public int getId() {
        return id;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }

   public void addDesenvolvedor(Funcionario dev){
        if (dev != null){
            this.desenvolvedores.add(dev);
        }
   }

    
    
    

}
