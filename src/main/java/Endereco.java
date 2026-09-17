public class Endereco {
    private int id;
    private String rua;
    private String num;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(int id, String rua, String num, String cep, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.num = num;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void atualizarEndereco(String rua, String num, String cep, String cidade, String estado) {
        if (rua != null) this.rua = rua;

        if (num != null) this.num = num;

        if (cep != null) this.cep = cep;

        if (cidade != null) this.cidade = cidade;

        if (estado != null) this.estado = estado;
    }

    public int getId() { return id; }
}
