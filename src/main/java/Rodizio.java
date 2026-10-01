import java.util.List;

public class Rodizio implements  Sprint{

    @Override
    public Funcionario escolherLider(List<Funcionario> devs, Funcionario atual) {
        if (devs.size() < 2) return devs.get(0);
        int i = devs.indexOf(atual);
        return devs.get((i + 1) % devs.size());
    }

}