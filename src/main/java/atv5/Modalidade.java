package atv5;

public interface Modalidade {
    
    double calcularCusto(Pedido pedido);
    int estimarPrazo(Pedido pedido);

}
