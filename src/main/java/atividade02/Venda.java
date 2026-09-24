package atividade02;

public class Venda{

    private float totalVenda;
    private int idVenda;
    private ItemVenda itemVenda;
    private Cliente cliente;

    public Venda(int idVenda){
        this.idVenda = idVenda;
    }


    public float calculaTotalVenda(float subtotal) {
        float total = subtotal;
        if (cliente.getPerfilAssinatura() == PerfilAssinatura.PREMIUM) {
            total = total * 0.95f; 
        }
        this.totalVenda = total;
        return total;
    }

    public float getTotalVenda(){
        return this.totalVenda;
    }
}