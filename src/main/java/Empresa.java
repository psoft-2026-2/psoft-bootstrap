import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Empresa {

    private Map<String, Funcionario> funcionarios;
    private List<ProdutoSoftware> produtosSoftware;
    private List<Time> times;
    private Funcionario productOwner;

    public Empresa() {
        this.funcionarios = new HashMap<>();
        this.produtosSoftware = new ArrayList<>();
        this.times = new ArrayList<>();
        this.productOwner = null;
    }

    public void cadastrarFuncionario(String nome, String cpf) {
        Funcionario funcionario = new Funcionario(nome, cpf);

        funcionarios.put(cpf, funcionario);
    }

    public void cadastrarProduto(String nome,String descricao) {

        ProdutoSoftware produto = new ProdutoSoftware(nome, descricao);

        produtosSoftware.add(produto);
    }

    public void cadastrarTime(String nome, String cpfGerente, int idProduto) {
        Funcionario gerente =
                buscarFuncionario(cpfGerente);

        ProdutoSoftware produto =
                buscarProduto(idProduto);

        if (!gerente.temCargo(new Gerente())) {
            throw new IllegalArgumentException(
                    "O funcionário informado não possui o cargo de gerente."
            );
        }

        Time time =
                new Time(
                        nome,
                        produto,
                        gerente
                );

        times.add(time);
    }

    public void setProductOwner(String cpf) {

        Funcionario funcionario =
                buscarFuncionario(cpf);

        if (!funcionario.temCargo(new Gerente())) {
            throw new IllegalArgumentException(
                    "Somente um gerente pode ser promovido a Product Owner."
            );
        }

        for (Time time : times) {

            if (time.getGerente().equals(funcionario)) {
                throw new IllegalStateException(
                        "Defina outro gerente para o time antes de promover este gerente a Product Owner."
                );
            }
        }

        if (productOwner != null
                && !productOwner.equals(funcionario)) {

            productOwner.removerCargo(
                    new ProductOwner()
            );
        }

        funcionario.removerCargo(
                new Gerente()
        );

        funcionario.adicionarCargo(
                new ProductOwner()
        );

        this.productOwner = funcionario;
    }

    public void adicionarCargoFuncionario(
            String cpf,
            String funcao) {

        Funcionario funcionario =
                buscarFuncionario(cpf);

        Funcao cargo =
                criarFuncao(funcao);

        funcionario.adicionarCargo(cargo);
    }

    public void comecarSprint(
            String nomeTime,
            String cpfLider) {

        Time time =
                buscarTimeObrigatorio(nomeTime);

        Funcionario lider =
                buscarFuncionario(cpfLider);

        time.iniciarSprint(lider);
    }

    public void adicionarDesenvolvedorTime(
            String nomeTime,
            String cpf) {

        Time time =
                buscarTimeObrigatorio(nomeTime);

        Funcionario funcionario =
                buscarFuncionario(cpf);

        time.adicionarDesenvolvedor(
                funcionario
        );
    }

    public void setGerenteTime(
            String nomeTime,
            String cpf) {

        Time time =
                buscarTimeObrigatorio(nomeTime);

        Funcionario funcionario =
                buscarFuncionario(cpf);

        time.setGerente(funcionario);
    }

    private Funcionario buscarFuncionario(
            String cpf) {

        Funcionario funcionario =
                funcionarios.get(cpf);

        if (funcionario == null) {
            throw new IllegalArgumentException(
                    "Funcionário não encontrado."
            );
        }

        return funcionario;
    }

    private ProdutoSoftware buscarProduto(
            int id) {

        for (ProdutoSoftware produto :
                produtosSoftware) {

            if (produto.getId() == id) {
                return produto;
            }
        }

        throw new IllegalArgumentException(
                "Produto não encontrado."
        );
    }

    private Time buscarTime(String nome) {

        for (Time time : times) {

            if (time.getNome()
                    .equalsIgnoreCase(nome)) {

                return time;
            }
        }

        return null;
    }

    private Time buscarTimeObrigatorio(
            String nome) {

        Time time = buscarTime(nome);

        if (time == null) {
            throw new IllegalArgumentException(
                    "Time não encontrado."
            );
        }

        return time;
    }

    private Funcao criarFuncao(
            String funcao) {

        String nome =
                funcao
                        .trim()
                        .toUpperCase(Locale.ROOT)
                        .replace(" ", "")
                        .replace("_", "");

        switch (nome) {

            case "DESENVOLVEDOR":
                return new Desenvolvedor();

            case "LIDER":
                return new Lider();

            case "GERENTE":
                return new Gerente();

            case "PRODUCTOWNER":
                return new ProductOwner();

            default:
                throw new IllegalArgumentException(
                        "Função inválida: " + funcao
                );
        }
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public Map<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<ProdutoSoftware> getProdutosSoftware() {
        return produtosSoftware;
    }

    public List<Time> getTimes() {
        return times;
    }
}