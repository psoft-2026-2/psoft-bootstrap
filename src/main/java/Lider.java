
public class Lider implements Papel {

    @Override
    public String getNome() {
        return "Lider";
    }

    @Override
    public String responsabilidades() {
        return "Coordena a equipe durante a sprint";
    }

    public void lideraEquipe() {
        System.out.println("Liderando a equipe nesta sprint...");
    }
}
