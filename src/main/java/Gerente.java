public class Gerente implements Papel {

    private String nome;

    public Gerente() {nome = "Gerente";}

    public String getNome() {return nome;}

    public String trabalha() {return "planeja prazos e aloca recursos";}

    @Override
    public String toString() {return nome;}
}
