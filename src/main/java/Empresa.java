import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    private  List<Funcionario> desenvolvedores; 
    private Map<Integer, Time> listaDoTime; 
    private Funcionario productOwner;
   
    public Empresa() {
        this.desenvolvedores = new  ArrayList<>(); 
        this.listaDoTime = new HashMap<>(); 

    }


    public Funcionario getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(Funcionario productOwner) {
        if (productOwner != null) {
            productOwner.setPapel(new ProdectOwner());
            
        }
        this.productOwner = productOwner; 
    }

    public  void addTime(int idTime, Funcionario gerente){
    if(gerente != null){
        gerente.setPapel(new  Gerente());
    }
    Time time = new Time(idTime, gerente); 
    this.listaDoTime.put(idTime, time);

    }
    public void addDesenvolvedor(String cpf ,Papel papel, String nome){
        Funcionario dev = new  Funcionario(cpf, papel, nome); 
        this.desenvolvedores.add(dev); 
    }
    
    public void addProdutoAoTime(int idTime, Produto produto) {
        Time time = this.listaDoTime.get(idTime); 
        if (time != null && produto != null) {
            time.setProduto(produto);
        }
    }

    public List<Funcionario> getDesenvolvedores() {
        return desenvolvedores;
    }


    public Map<Integer, Time> getListaDoTime() {
        return listaDoTime;
    }

    public void addDesenvolvedorAoTime(int idTime, Funcionario dev) {
        Time time = this.listaDoTime.get(idTime);
    
   
    if (time != null && dev != null && this.desenvolvedores.contains(dev)) {
        time.addDesenvolvedor(dev);
    } else {
        System.out.println("Desenvolvedor não encontrado na empresa ou time inexistente.");
    }
}

        
    }




  

    

    

    
}
