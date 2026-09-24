public class Cliente {
    private String cpf;
    private String nome;
    private boolean isPremium;

    
    public Cliente(String cpf, String nome, boolean isPremium) {
        this.cpf = cpf;
        this.nome = nome;
        this.isPremium = isPremium;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void switchPremium() {
        this.isPremium = !this.isPremium;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", isPremium=" + isPremium + "]";
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
}
