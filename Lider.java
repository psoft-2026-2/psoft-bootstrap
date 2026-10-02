public class Lider {
    private Pessoa desenvolvedor;

    public Lider(Pessoa desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public void liderarSprint(Sprint sprint) {
        System.out.println(
            desenvolvedor + " está liderando a Sprint."
        );
    }
}