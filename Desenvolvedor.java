public class Desenvolvedor implements Papel {

    @Override
    public void realizarTrabalho() { 
        System.out.println("Desenvolvendo"); 
    }
    
    @Override
    public boolean equals(Object obj) { 
        return obj != null && this.getClass() == obj.getClass(); 
    }
    
    @Override
    public int hashCode() { 
        return this.getClass().hashCode(); 
    }
}
