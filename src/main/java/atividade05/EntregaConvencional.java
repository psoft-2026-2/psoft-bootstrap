package atividade05;

public class EntregaConvencional implements  EstrategiaEntrega {
    private double tarifaFixa; 

    

    public EntregaConvencional(double tarifaFixa) {
        this.tarifaFixa = tarifaFixa;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return tarifaFixa + (pedido.getDistanciaKm() * 1.5);

        
    }

    @Override
    public int calcularPrazoDeEntrega(Pedido pedido) {
        return  (int) Math.ceil(pedido.getDistanciaKm() / 100.0) + 2;
    }
    
}
