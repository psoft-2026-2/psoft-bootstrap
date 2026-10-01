import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private String cnpj;
    private Pessoa productOwner;
    private List times;

    public Empresa(String nome, String cnpj, Pessoa productOwner) {
        if (!productOwner.temPapel("Product Owner")) {
            throw new IllegalArgumentException("A pessoa indicada deve ter o papel de Product Owner!");
        }
        this.nome = nome;
        this.cnpj = cnpj;
        this.productOwner = productOwner;
        this.times = new ArrayList<>();
    }

    public void cadastrarTime(Time t) {
        if (!times.contains(t)) {
            this.times.add(t);
        }
    }

    public void definirProductOwner(Pessoa novoPO) {
        if (!novoPO.temPapel("Product Owner")) {
            novoPO.adicionarPapel(new ProductOwner("Visão Global dos Produtos"));
        }
        this.productOwner = novoPO;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public Pessoa getProductOwner() { return productOwner; }
    public List getTimes() { return times; }
}