package atividade05;

public class EntregaEconomica implements  EstrategiaEntrega {
    private int prazo; 

    
    

    public EntregaEconomica(int prazo) {
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
      // Preço reduzido aplicando uma tarifa menor por km
      return pedido.getDistanciaKm() * 0.8; 
    }

    @Override
    public int calcularPrazoDeEntrega(Pedido pedido) {
       return  this.prazo; 
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getPrazo() {
        return prazo;
    }
    
}
