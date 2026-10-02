import java.util.Arrays;

public final class Empresa {
    private String nome;
    private Pessoa productManager;
    private Time[] times;
    private Produto[] produtos;
    private Pessoa[] funcionarios;

    public Empresa(String nome, Pessoa productManager, Time[] times, Produto[] produtos, Pessoa[] funcionarios) {
        this.nome = nome;
        this.productManager = productManager;
        this.times = times;
        this.produtos = produtos;
        this.funcionarios = funcionarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getProductManager() {
        return productManager;
    }

    public void setProductManager(Pessoa productManager) {
        this.productManager = productManager;
    }

    public Time[] getTimes() {
        return times;
    }

    public void setTimes(Time[] times) {
        this.times = times;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public Pessoa[] getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Pessoa[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void contratar(Pessoa funcionario) {
        if (buscarFuncionario(funcionario.getCpf()) != null) {
            throw new IllegalArgumentException("CPF já cadastrado na empresa");
        }
        Pessoa[] novosFuncionarios = Arrays.copyOf(funcionarios, funcionarios.length + 1);
        novosFuncionarios[funcionarios.length] = funcionario;
        funcionarios = novosFuncionarios;
    }

    public Pessoa buscarFuncionario(String cpf) {
        for (Pessoa funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public boolean possuiProduto(Produto produto) {
        for (Produto cadastrado : produtos) {
            if (cadastrado == produto) {
                return true;
            }
        }
        return false;
    }

    public void cadastrarProduto(Produto produto) {
        if (possuiProduto(produto)) {
            throw new IllegalArgumentException("Produto já cadastrado na empresa");
        }
        Produto[] novosProdutos = Arrays.copyOf(produtos, produtos.length + 1);
        novosProdutos[produtos.length] = produto;
        produtos = novosProdutos;
    }

    public void adicionarTime(Time time) {
        for (Time cadastrado : times) {
            if (cadastrado == time || cadastrado.getSprint() == time.getSprint()) {
                throw new IllegalArgumentException("Time ou sprint já cadastrado na empresa");
            }
        }
        if (!possuiProduto(time.getProduto())) {
            throw new IllegalArgumentException("Produto do time deve estar cadastrado na empresa");
        }
        Pessoa gerente = time.getGerente();
        if (buscarFuncionario(gerente.getCpf()) != gerente) {
            throw new IllegalArgumentException("Gerente deve ser funcionário da empresa");
        }
        for (Pessoa dev : time.getDevs()) {
            if (buscarFuncionario(dev.getCpf()) != dev) {
                throw new IllegalArgumentException("Desenvolvedor deve ser funcionário da empresa");
            }
        }
        Time[] novosTimes = Arrays.copyOf(times, times.length + 1);
        novosTimes[times.length] = time;
        times = novosTimes;
    }
}
