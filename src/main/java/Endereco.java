public class Endereco {

    private String cep;
    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco(String cep, String rua, String bairro, int numero, String cidade, String estado, String complemento) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
    }

    public String get_cep() {
        return this.cep;
    }

    public void set_cep(String novo_cep) {
        this.cep = novo_cep;
    }

    public String get_rua() {
        return this.rua;
    }

    public void set_rua(String nova_rua) {
        this.rua = nova_rua;
    }

    public String get_bairro() {
        return this.bairro;
    }

    public void set_bairro(String novo_bairro) {
        this.bairro = novo_bairro;
    }

    public int get_numero() {
        return this.numero;
    }

    public void set_numero(int novo_numero) {
        this.numero = novo_numero;
    }

    public String get_cidade() {
        return this.cidade;
    }

    public void set_cidade(String nova_cidade) {
        this.cidade = nova_cidade;
    }

    public String get_estado() {
        return this.estado;
    }

    public void set_estado(String novo_estado) {
        this.estado = novo_estado;
    }

    public String get_complemento() {
        return this.complemento;
    }

    public void set_complemento(String novo_complemento) {
        this.complemento = novo_complemento;
    }
}
