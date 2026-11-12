public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cep;

    public Endereco(String rua, String numero, String bairro, String cep) {
        setRua(rua);
        setNumero(numero);
        setBairro(bairro);
        setCep(cep);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua == null || rua.trim().isEmpty()) {
            throw new IllegalArgumentException("Rua do endereco nao pode ser nula ou vazia");
        }
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Numero do endereco nao pode ser nulo ou vazio");
        }
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("Bairro do endereco nao pode ser nulo ou vazio");
        }
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep == null || cep.trim().isEmpty()) {
            throw new IllegalArgumentException("CEP do endereco nao pode ser nulo ou vazio");
        }
        this.cep = cep;
    }

    public String toString() {
        return "Endereco{rua='" + rua + "', numero='" + numero
                + "', bairro='" + bairro + "', cep='" + cep + "'}";
    }
}
