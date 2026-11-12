import java.math.BigDecimal;

//Temos que fazer o padrão strategy aqui
public interface ModalidadeEntrega {

    String getNome();
    BigDecimal calcularCusto(Pedido pedido);

    int calcularPrazo(Pedido pedido);
}
