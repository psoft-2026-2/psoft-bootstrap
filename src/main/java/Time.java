import java.util.Arrays;

public final class Time {
    private String nome;
    private Pessoa gerente;
    private Pessoa[] devs;
    private Sprint sprint;
    private Produto produto;

    public Time(String nome, Pessoa gerente, Pessoa[] devs, Sprint sprint, Produto produto) {
        this.nome = nome;
        this.gerente = gerente;
        this.devs = devs;
        this.sprint = sprint;
        this.produto = produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public void setGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public Pessoa[] getDevs() {
        return devs;
    }

    public void setDevs(Pessoa[] devs) {
        this.devs = devs;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pessoa buscarIntegrante(String cpf) {
        if (gerente.getCpf().equals(cpf)) {
            return gerente;
        }
        for (Pessoa dev : devs) {
            if (dev.getCpf().equals(cpf)) {
                return dev;
            }
        }
        return null;
    }

    public void adicionarDev(Pessoa dev) {
        if (!(dev.getFuncao() instanceof Dev)) {
            throw new IllegalArgumentException("Desenvolvedor deve exercer a função Dev");
        }
        if (buscarIntegrante(dev.getCpf()) != null) {
            throw new IllegalArgumentException("Pessoa já pertence ao time");
        }
        Pessoa[] integrantes = Arrays.copyOf(devs, devs.length + 1);
        integrantes[devs.length] = dev;
        devs = integrantes;
    }

    public void removerDev(String cpf) {
        if (sprint.getLider().equals(cpf)) {
            throw new IllegalArgumentException("Troque o líder da sprint antes de removê-lo");
        }
        for (int i = 0; i < devs.length; i++) {
            if (devs[i].getCpf().equals(cpf)) {
                Pessoa[] integrantes = Arrays.copyOf(devs, devs.length - 1);
                for (int j = i; j < integrantes.length; j++) {
                    integrantes[j] = devs[j + 1];
                }
                devs = integrantes;
                return;
            }
        }
        throw new IllegalArgumentException("Desenvolvedor não pertence ao time");
    }

    public Pessoa getLiderSprint() {
        return buscarIntegrante(sprint.getLider());
    }

    public void definirLiderSprint(Pessoa lider) {
        if (!lider.isLider() || buscarIntegrante(lider.getCpf()) != lider) {
            throw new IllegalArgumentException("Líder deve ser um integrante com o papel de liderança");
        }
        sprint.setLider(lider.getCpf());
    }
}
