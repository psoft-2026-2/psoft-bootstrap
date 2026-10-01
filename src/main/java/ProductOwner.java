public class ProductOwner implements Papel {
    private String visaoProduto;

    public ProductOwner(String visaoProduto) {
        this.visaoProduto = visaoProduto;
    }

    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public void executar() {
        System.out.println("-> Definindo a visão global, alinhando com stakeholders e priorizando o backlog do produto.");
    }
}