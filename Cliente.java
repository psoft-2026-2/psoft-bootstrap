public class Cliente {

    public enum Assinatura {
        PREMIUM(0.10f),
        STANDARD(0.05f);

        private final float desconto;

        Assinatura(float desconto) {
            this.desconto = desconto;
        }

        public float getDesconto() {
            return desconto;
        }
    }

    private String nome;
    private Assinatura assinatura;
    private String cpf;

    public Cliente(String nome, Assinatura assinatura, String cpf) {
        this.nome = nome;
        this.assinatura = assinatura;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Assinatura getAssinatura() {
        return this.assinatura;
    }

    public float getDesconto() {
        return this.assinatura.getDesconto();
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " Assinatura: " + assinatura;
    }
}