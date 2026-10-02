import java.util.ArrayList;
import java.util.List;

public class LiderDecorator implements Cargo {

    private Cargo cargoBase;

    public LiderDecorator(Cargo cargoBase) {
        this.cargoBase = cargoBase;
    }

    @Override
    public Funcionario promover(Funcionario funcionario) {
        return funcionario;
    }

    @Override
    public List<String> getFuncoes() {
        List<String> funcoes =
                new ArrayList<>(cargoBase.getFuncoes());

        funcoes.add("Líder");

        return funcoes;
    }

    public Cargo getCargoBase() {
        return cargoBase;
    }
}