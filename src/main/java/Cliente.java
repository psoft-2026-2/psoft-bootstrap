public class Cliente {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private ClientePerfil clientePerfil ;

    public Cliente(String nome, String cpf, String endereco, String telefone, ClientePerfil clientePerfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.clientePerfil = clientePerfil;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }
     public ClientePerfil getClientePerfil() {
        return clientePerfil;
    }

    public void setClientePerfil(ClientePerfil clientePerfil) {
        this.clientePerfil = clientePerfil;
    }

    public double ativaDesconto(double valorTotal) {
        return clientePerfil.calcularDesconto(valorTotal);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente:" + "\n" +
        "nome : " + nome + "\n" +
        "endereco : " + endereco + "\n" +
        "telefone : " + telefone + "\n" +
        "clientePerfil : " + clientePerfil;
    }

}
