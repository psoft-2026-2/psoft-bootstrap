public class Cliente extends Pessoa {
    
    public Cliente(String nome, int idade, String cpf, String telefone, String profissao) {
        super(nome, idade, cpf, telefone, profissao);
    }

    public List<Cartao> getCartoes() {
        return new ArrayList<>(Cartao);
    }

    public void adicionarCartao(Cartao cartao) {
        Cartao.add(cartao);
    }

    public void removerCartao(Cartao cartao) {
        Cartao.remove(cartao);
    }

    public void comprar(double valor){
        System.out.println("Compra realizada no valor de: " + valor);
    }

    public void pagar(Pagamento pagamento){
        System.out.println(
            getNome()
                    + " realizou um pagamento de R$ "
                    + pagamento.getValor()
                    + " via "
                    + pagamento.getTipo()
        );
    }
}