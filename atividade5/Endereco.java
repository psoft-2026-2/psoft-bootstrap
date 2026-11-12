public class Endereco {
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;

    public Endereco(String rua, String bairro, String cep, String cidade) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getEndereco() {
        return rua + ", " + bairro + ", " + cidade + " - CEP " + cep;
    }

    public String getRua() { 
        return rua; 
    }

    public void setRua(String rua) { 
        this.rua = rua; 
    }

    public String getBairro() { 
        return bairro; 
        
    }
    public void setBairro(String bairro) { 
        this.bairro = bairro; 
    }

    public String getCep() { 
        return cep; 
    }
    
    public void setCep(String cep) { 
        this.cep = cep; 
    }

    public String getCidade() { 
        return cidade; 
    }

    public void setCidade(String cidade) { 
        this.cidade = cidade; 
    }
}
