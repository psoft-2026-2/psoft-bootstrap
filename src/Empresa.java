public class Empresa {
    private String nome;
    private String cnpj;
    private List<Times> times;
    private List<Produtos> produtos;
    private List<Membros> membros;


    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.times = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    public void CadastrarTime(Times time) {
        this.times.add(time);
    }

    public void CadastrarProduto(Produtos produto) {
        this.produtos.add(produto);
    }

    public void CadastrarMembro(Membros membro) {
        this.membros.add(membro);
    }

    public void PromoverMembro(Membros membro) {
        if (this.membros.contains(membro)) {
            membro.promover();
        } else {
            System.out.println("Membro não encontrado na empresa.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}