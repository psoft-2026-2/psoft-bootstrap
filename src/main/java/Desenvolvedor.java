public class Desenvolvedor implements Papel {

    private String nome;

    public Desenvolvedor() {nome = "Desenvolvedor";}

    public String getNome() {return nome;}

    public String trabalha() {return "escreve, testa e revisa código";}

    @Override
    public String toString() {return nome;}
}
