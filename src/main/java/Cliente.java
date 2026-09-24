public class Cliente {
    private String nome;
    private String cpf;
    private PerfilCliente perfil;

    public Cliente(String nome, String cpf, PerfilCliente perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public PerfilCliente getPerfil() {
        return perfil;
    }

    public boolean setPerfil(PerfilCliente newPerfil) {
        if (newPerfil == null) {
            return false;
        }
        this.perfil = newPerfil;
        return true;
    }

    public boolean temDesconto() {
        return perfil.getDesconto() > 0;
    }

    public int getDesconto() {
        return perfil.getDesconto();
    }
}