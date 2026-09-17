public class Endereco {
    private String numero;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidadeUF;

    public Endereco(String numero, String logradouro, String bairro, String cep, String cidadeUF) {
        validarCampo(numero, "numero");
        validarCampo(logradouro, "logradouro");
        validarCampo(bairro, "bairro");
        validarCampo(cep, "cep");
        validarCampo(cidadeUF, "cidadeUF");
        this.numero = numero;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidadeUF = cidadeUF;
    }

    private void validarCampo(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " nao pode ser nulo ou vazio");
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validarCampo(numero, "numero");
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        validarCampo(logradouro, "logradouro");
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarCampo(bairro, "bairro");
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        validarCampo(cep, "cep");
        this.cep = cep;
    }

    public String getCidadeUF() {
        return cidadeUF;
    }

    public void setCidadeUF(String cidadeUF) {
        validarCampo(cidadeUF, "cidadeUF");
        this.cidadeUF = cidadeUF;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "numero='" + numero + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidadeUF='" + cidadeUF + '\'' +
                '}';
    }
}
