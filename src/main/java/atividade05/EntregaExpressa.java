package atividade05;

public class EntregaExpressa  implements  EstrategiaEntrega{
    private double CustoAdicionalPrioridade; 

    
    public EntregaExpressa(double custoAdicionalPrioridade) {
        CustoAdicionalPrioridade = custoAdicionalPrioridade;
    }
    

    @Override
    public double calcularCusto(Pedido pedido) {
        return  (pedido.getDistanciaKm() * 2.5) + this.CustoAdicionalPrioridade; 
    }

    @Override
    public int calcularPrazoDeEntrega(Pedido pedido) {
        return 1; 
       
    }


    public double getCustoAdicionalPrioridade() {
        return CustoAdicionalPrioridade; // TODO Auto-generated method stub
    }


    public void setCustoAdicionalPrioridade(double custoAdicionalPrioridade) {
        CustoAdicionalPrioridade = custoAdicionalPrioridade;
    }
    
}
