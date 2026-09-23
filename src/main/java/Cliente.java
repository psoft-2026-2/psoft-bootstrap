public class Cliente {
    private final String nome;
    private final Perfil perfil;

    public Cliente(String nome, Perfil perfil) {
        if (nome == null || nome.isBlank() || perfil == null) {
            throw new IllegalArgumentException("Nome e perfil sao obrigatorios.");
        }
        this.nome = nome;
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public double getDesconto() {
        return perfil.getDesconto();
    }
}
