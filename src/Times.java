public class Times {
    private String idTime;
    private String nome;
    private Membros gerente;
    private List<Membros> desenvolvedores;
    private List<Sprints> sprints;

    public Times(String nome) {
        this.nome = nome;
        this.desenvolvedores = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public void IndicarGerente(Membros gerente) {
        this.gerente = gerente;
    }
    

    public void adicionarDesenvolvedor(Membros membro) {
        this.desenvolvedores.add(membro);
    }

    public Sprint CriarSprint(String nome) {
        Sprint sprint = new Sprint(nome);
        this.sprints.add(sprint);
        return sprint;
    }


    public String getNome() {
        return nome;
    }

    public List<Membros> getDesenvolvedores() {
        return desenvolvedores;
    }

    public Produto getProduto() {
        return produto;
    }
}