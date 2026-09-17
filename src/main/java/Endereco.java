public class Endereco {
    private int idEndereco;
    private String cidade;
    private String rua;
    private int numero;
    
    public Endereco(int idEndereco, String rua, String cidade, int numero) {
        this.idEndereco = idEndereco;
        this.rua = rua;
        this.cidade = cidade;
        this.numero = numero;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idEndereco;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        if (idEndereco != other.idEndereco)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Endereco [cidade=" + cidade + ", rua=" + rua + ", numero=" + numero + "]";
    }
    
}
