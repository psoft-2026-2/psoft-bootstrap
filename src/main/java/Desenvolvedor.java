public class Desenvolvedor implements Papel{
    private int nivel;

    public Desenvolvedor(){
        this.nivel = 3;
    }

    public String toString(){
        return "DESENVOLVEDOR";
    }

    public int getNivel() {
        return nivel;
    }

}
