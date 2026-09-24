public class Cliente {
    
    private String nome;
    private String cpf;
    private Assinatura perfil;

    public Cliente(String nome, String cpf, Assinatura perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public double getDesconto() {
        return perfil.calculaDesconto();
    }

    public void atualizarPerfil(Assinatura novoPerfil) {
        this.perfil = novoPerfil;
    }
    
}