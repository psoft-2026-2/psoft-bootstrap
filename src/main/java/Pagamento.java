public class Pagamento {
    private String metodo;
    private float taxa;
    private float valorBruto;

    public Pagamento(String metodo, float taxa) {
        this.metodo = metodo;
        this.taxa = taxa;
        this.valorBruto = 0;
    }

    public float pagamentoBruto() {
        return valorBruto;
    }

    public float pagamentoLiquido() {
        return valorBruto * (1 - taxa);
    }

    String getMetodo() {
        return metodo;
    }

    void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    float getTaxa() {
        return taxa;
    }

    void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    float getValorBruto() {
        return valorBruto;
    }

    void setValorBruto(float valorBruto) {
        this.valorBruto = valorBruto;
    }
}
