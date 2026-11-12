package atv5;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private int numero;

    public Endereco(String rua, int numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getRua() { 
        return rua; 
    }
    public String getBairro() { 
        return bairro; 
    }
    public String getCidade() { 
        return cidade; 
    }
    public String getEstado() { 
        return estado; 
    }
    public String getCep() { 
        return cep; 
    }
    public int getNumero() { 
        return numero; 
    }
}