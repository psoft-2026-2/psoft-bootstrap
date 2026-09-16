public class Address {
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Address(int numero, String rua, String bairro, String cidade, String estado){
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.rua = rua;
    }
}
