import java.util.ArrayList;
import java.util.List;

public class Time {
    private Funcionario gerente;
    private List<Funcionario> desenvolvedores;

    public Time(Funcionario gerente){
        if(!gerente.getPapel().equals("Gerente"))
            throw new IllegalArgumentException("O líder do time deve ter o papel de Gerente.");
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
    }

    public void addDesenvolvedor(Funcionario dev){
        if(!dev.getPapel().equals("Desenvolvedor"))
            throw new IllegalArgumentException("Apenas desenvolvedores podem entrar nesta lista.");
        this.desenvolvedores.add(dev);
    }

    public void removerDesenvolvedor(Funcionario dev){
        desenvolvedores.remove(dev);
    }

    public Funcionario getGerente(){
        return this.gerente;
    }

    public List<Funcionario> getDesenvolvedores(){
        return this.desenvolvedores;
    }

    @Override 
    public String toString(){
        String toString = gerente.toString() + "\n"; 
        for(Funcionario dev : desenvolvedores)
            toString += dev.toString() + "\n";
        return toString;
    }
        
}
