public class Funcionario {
    private String id;
    private String nome;
    private Papel papel;
    private boolean ehLider;

    public Funcionario(String id, String nome, Papel papel)
    {
        this.id = id;
        this.nome = nome;
        this.papel = papel;
        this.ehLider = false;
    }

    public String getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public Papel getPapel()
    {
        return this.papel;
    }

    public boolean isEhLider()
    {
        return this.ehLider;
    }

    public void setEhLider(boolean ehLider)
    {
        if (ehLider && this.papel != Papel.DESENVOLVEDOR)
        {
            throw new IllegalStateException("Apenas desenvolvedores podem liderar a sprint.");
        }
        this.ehLider = ehLider;
    }

    public void promoverParaGerente()
    {
        if (this.papel != Papel.DESENVOLVEDOR)
        {
            throw new IllegalStateException("Apenas desenvolvedores podem ser promovidos a gerente.");
        }
        this.papel = Papel.GERENTE;
        this.ehLider = false;
    }

    public void promoverParaProductOwner()
    {
        if (this.papel != Papel.GERENTE)
        {
            throw new IllegalStateException("Apenas gerentes podem ser promovidos a Product Owner.");
        }
        this.papel = Papel.PRODUCT_OWNER;
        this.ehLider = false;
    }
}