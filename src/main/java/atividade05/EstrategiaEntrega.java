package atividade05;

public interface EstrategiaEntrega {
    double calcularCusto(Pedido pedido); 
    int calcularPrazoDeEntrega(Pedido pedido); 
    
}
