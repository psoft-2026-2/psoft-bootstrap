public class Lider implements Papel{
    private int nivel;
    public Lider(){
        this.nivel = 2;
    }

    public String toString(){
        return "LIDER";
    }

    public int getNivel() {
        return nivel;
    }
}
