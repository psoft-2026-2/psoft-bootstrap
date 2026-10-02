import java.util.Hashtable;
import java.util.List;

public class Empresa {

    private Funcionario productOwner;

    private final Hashtable<String, Funcionario> funcionarios;

    private final Hashtable<String, Projeto> projetos;

    public Empresa() {

        this.funcionarios = new Hashtable<>();
        this.projetos = new Hashtable<>();
    }


    public void contratar(
            String nome,
            String cpf,
            float salario
    ) {

        if (funcionarios.containsKey(cpf)) {
            throw new IllegalArgumentException(
                    "Já existe um funcionário com o CPF informado."
            );
        }

        funcionarios.put(
                cpf,
                new Funcionario(nome, cpf, salario)
        );
    }

    public void demitir(String cpf) {

        Funcionario funcionario =
                obterFuncionario(cpf);

        if (funcionario.equals(productOwner)) {
            productOwner = null;
        }

        funcionarios.remove(cpf);
    }


    public void elejerProductOwner(String cpf) {

        if (productOwner != null) {
            throw new IllegalArgumentException(
                    "A empresa já possui um Product Owner."
            );
        }

        Funcionario funcionario =
                obterFuncionario(cpf);

        funcionario.promoverAPO();

        productOwner = funcionario;
    }

    public void elegerProductOwner(String cpf) {
        elejerProductOwner(cpf);
    }


    public void promover(String cpf) {

        Funcionario funcionario =
                obterFuncionario(cpf);

        funcionario.promoverAGerente();
    }

    public void darAumento(
            String cpf,
            float valor
    ) {

        obterFuncionario(cpf)
                .aumento(valor);
    }


    public void criarProjeto(
            String idProjeto,
            String cpf,
            String descricao
    ) {

        if (projetos.containsKey(idProjeto)) {
            throw new IllegalArgumentException(
                    "Já existe um projeto com o ID informado."
            );
        }

        Funcionario gerente =
                obterFuncionario(cpf);

        if (!gerente.ehGerente()) {
            throw new IllegalArgumentException(
                    "Somente um funcionário com cargo de Gerente pode criar um projeto."
            );
        }

        projetos.put(
                idProjeto,
                new Projeto(
                        idProjeto,
                        gerente,
                        descricao
                )
        );
    }


    public void addDesenvolvedorEmProjeto(
            String cpf,
            String idProjeto
    ) {

        Projeto projeto =
                obterProjeto(idProjeto);

        Funcionario funcionario =
                obterFuncionario(cpf);

        projeto.incluirDesenvolvedor(funcionario);
    }


    public void removerDesenvolvedorDeProjeto(
            String cpf,
            String idProjeto
    ) {

        Projeto projeto =
                obterProjeto(idProjeto);

        Funcionario funcionario =
                obterFuncionario(cpf);

        projeto.removerDesenvolvedor(funcionario);
    }


    public void criarSprint(
            String cpf,
            String idProjeto,
            String descricao
    ) {

        Projeto projeto =
                obterProjeto(idProjeto);

        Funcionario funcionario =
                obterFuncionario(cpf);

        projeto.criarSprint(
                funcionario,
                descricao
        );
    }


    public void excluirProjeto(
            String idProjeto
    ) {

        if (projetos.remove(idProjeto) == null) {

            throw new IllegalArgumentException(
                    "Projeto não encontrado: " + idProjeto
            );
        }
    }


    public void sprintsDeProjeto(
            String idProjeto
    ) {

        List<Sprint> sprints =
                obterProjeto(idProjeto)
                        .getSprints();

        for (Sprint s : sprints) {
            System.out.println(s);
            System.out.println();
        }
    }


    public void ListarTimeDeProjeto(
            String idProjeto
    ) {

        System.out.println(
                obterProjeto(idProjeto)
                        .getTime()
        );
    }


    public void listarTimeDeProjeto(
            String idProjeto
    ) {

        ListarTimeDeProjeto(idProjeto);
    }


    public void entregarProjeto(
            String idProjeto
    ) {

        obterProjeto(idProjeto)
                .entregarProjeto();
    }

  
    public void listarFuncionarios() {

        for (Funcionario funcionario :
                funcionarios.values()) {

            System.out.println(funcionario);
        }
    }


    public void listarProjetos() {

        for (Projeto projeto :
                projetos.values()) {

            System.out.println(projeto);
            System.out.println();
        }
    }


    public Funcionario getFuncionario(
            String cpf
    ) {

        return obterFuncionario(cpf);
    }


    public Funcionario getProductOwner() {
        return productOwner;
    }


    public Projeto getProjeto(
            String idProjeto
    ) {

        return obterProjeto(idProjeto);
    }


    private Funcionario obterFuncionario(
            String cpf
    ) {

        if (cpf == null ||
                !funcionarios.containsKey(cpf)) {

            throw new IllegalArgumentException(
                    "Funcionário não encontrado: " + cpf
            );
        }

        return funcionarios.get(cpf);
    }


    private Projeto obterProjeto(
            String idProjeto
    ) {

        if (idProjeto == null ||
                !projetos.containsKey(idProjeto)) {

            throw new IllegalArgumentException(
                    "Projeto não encontrado: " + idProjeto
            );
        }

        return projetos.get(idProjeto);
    }
}