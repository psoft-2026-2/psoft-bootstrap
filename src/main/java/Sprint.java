public class Sprint {

    private final Funcionario lider;
    private final String descricao;

    public Sprint(Funcionario funcionario, String descricao) {

        if (funcionario == null || !funcionario.ehDesenvolvedor()) {
            throw new IllegalArgumentException(
                    "O líder de uma Sprint deve ser um desenvolvedor."
            );
        }

        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException(
                    "A descrição da Sprint é obrigatória."
            );
        }

        this.lider = funcionario;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Funcionario getLider() {
        return this.lider;
    }

    @Override
    public String toString() {

        return "Líder: " + this.lider.getNome() + "\n" +
                "Descrição: " + this.descricao;
    }
}