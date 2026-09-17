import psoft.model.Papel;
import psoft.service.ListaDePessoas;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaDePessoas lista = new ListaDePessoas();

        lista.createPessoa("Ana Larissa", 22, "12345678900", "83999999999",
                List.of("Rua A, 123"), "Estudante", Papel.CLIENTE);

        System.out.println(lista.getPessoas());

        lista.deletePessoa("12345678900");
        System.out.println(lista.getPessoas());
    }
}