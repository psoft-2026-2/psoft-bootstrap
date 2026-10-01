/**
 * Funcionario
 */
public class Funcionario {
    private  String cpf; 
    private  Papel papel; 
    private String nome;
    
    public Funcionario(String cpf, Papel papel, String nome) {
        this.cpf = cpf;
        this.papel = papel;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }



    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public String getNome() {
        return nome;
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
        Funcionario other = (Funcionario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

   
    

    

}
