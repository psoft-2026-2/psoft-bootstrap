import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome, cnpj;
    private List<Funcionario> funcionarios;
    private List<Time> historicoDeTimes;
    private Funcionario productOwner;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        funcionarios = new ArrayList<>();
        historicoDeTimes = new ArrayList<>();
    }

    public void addFuncionario(Funcionario funcionario) {
        if (funcionarios.contains(funcionario))
            throw new IllegalArgumentException("Matrícula já cadastrada: " + funcionario.getMatricula());
        funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        if (!funcionarios.remove(funcionario))
            throw new IllegalArgumentException("Funcionário não encontrado: " + funcionario.getMatricula());
        if (funcionario.equals(productOwner))
            productOwner = null;
    }

    public Funcionario procuraFuncionario(String matricula) {
        return funcionarios.stream()
                .filter(f -> f.getMatricula().equals(matricula))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado: " + matricula));
    }

    public void addTime(Time time) {
        if (historicoDeTimes.contains(time))
            throw new IllegalArgumentException("Time já cadastrado: " + time.getId());
        if (!funcionarios.contains(time.getLider()))
            throw new IllegalArgumentException("Líder não pertence à empresa: " + time.getLider().getNome());
        historicoDeTimes.add(time);
    }

    public Time procuraTime(String id) {
        return historicoDeTimes.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Time não encontrado: " + id));
    }

    public void setProductOwner(Funcionario funcionario) {
        if (!funcionarios.contains(funcionario))
            throw new IllegalArgumentException("Funcionário não pertence à empresa: " + funcionario.getNome());
        if (!funcionario.temPapel(ProductOwner.class))
            funcionario.addPapel(new ProductOwner());
        productOwner = funcionario;
    }

    public void promoveFuncionario(Funcionario funcionario, Papel novoPapel) {
        if (!funcionarios.contains(funcionario))
            throw new IllegalArgumentException("Funcionário não pertence à empresa: " + funcionario.getNome());
        funcionario.addPapel(novoPapel);
    }

    public String getNome() {return nome;}

    public String getCnpj() {return cnpj;}

    public List<Funcionario> getFuncionarios() {return funcionarios;}

    public List<Time> getHistoricoDeTimes() {return historicoDeTimes;}

    public Funcionario getProductOwner() {return productOwner;}

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Software House", "12.345.678/0001-90");

        Funcionario ana = new Funcionario("Ana", "001");
        Funcionario bruno = new Funcionario("Bruno", "002");
        Funcionario carla = new Funcionario("Carla", "003");
        ana.addPapel(new Desenvolvedor());
        bruno.addPapel(new Desenvolvedor());
        carla.addPapel(new Gerente());
        empresa.addFuncionario(ana);
        empresa.addFuncionario(bruno);
        empresa.addFuncionario(carla);

        empresa.promoveFuncionario(ana, new Lider());
        empresa.setProductOwner(carla);

        System.out.println("=== Funcionários ===");
        empresa.getFuncionarios().forEach(System.out::println);

        System.out.println("\n=== Papéis em ação ===");
        for (Papel papel : ana.getPapeis())
            System.out.println(ana.getNome() + " como " + papel + ": " + papel.trabalha());

        ProdutoSoftware app = new ProdutoSoftware("App de Delivery", "Pedidos online", empresa.getProductOwner());
        Time timeAlpha = new Time("alpha", ana);
        empresa.addTime(timeAlpha);

        System.out.println("\n=== Sprints ===");
        Sprint sprint1 = timeAlpha.novoSprint("S1", app);
        sprint1.inicia("01/10/2026");
        System.out.println(timeAlpha);
        System.out.println(sprint1);
        sprint1.termina("15/10/2026");
        Sprint sprint2 = timeAlpha.novoSprint("S2", app);
        sprint2.inicia("16/10/2026");
        System.out.println(timeAlpha);
        System.out.println(sprint2);

        System.out.println("\n=== Tentativas inválidas ===");
        try {
            new Time("beta", bruno);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            timeAlpha.novoSprint("S3", app);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            sprint1.inicia("20/10/2026");
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            empresa.procuraFuncionario("999");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        empresa.removeFuncionario(carla);
        System.out.println("\nProduct Owner após remoção de Carla: " + empresa.getProductOwner());
    }
}
