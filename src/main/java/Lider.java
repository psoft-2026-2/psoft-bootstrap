public class Lider implements Papel {

    private String nome;

    public Lider() {nome = "Líder";}

    public String getNome() {return nome;}

    public String trabalha() {return "coordena o time e remove impedimentos";}

    @Override
    public String toString() {return nome;}
}
