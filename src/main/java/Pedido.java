
import java.util.Date;

import Modalidades.Modalidade;

/**
 * Pedido
 */
public class Pedido {

    private Cliente cliente;
    private Endereco endOrigem;
    private Endereco endDestino;
    private Float peso;
    private Float distanciaEstimada;
    private Modalidade modalidade;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Endereco endOrigem, Endereco endDestino, Float peso, Float distanciaEstimada, Modalidade modalidade) {
        this.cliente = cliente;
        this.endOrigem = endOrigem;
        this.endDestino = endDestino;
        this.peso = peso;
        this.distanciaEstimada = distanciaEstimada;
        this.modalidade = modalidade;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEndOrigem(Endereco endOrigem) {
        this.endOrigem = endOrigem;
    }

    public void setEndDestino(Endereco endDestino) {
        this.endDestino = endDestino;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setDistanciaEstimada(Float distanciaEstimada) {
        this.distanciaEstimada = distanciaEstimada;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public double calculaCusto() {
        return this.modalidade.calculaCusto(this.distanciaEstimada);
    }

    public Date calculaPrazo() {
        return this.modalidade.calculaPrazo(this.distanciaEstimada);
    }

    public void setModalidadePedido(Pedido pedido, Modalidade modalidade) {
        pedido.setModalidade(modalidade);
    }

    public void acompanharPedido(Pedido pedido) {
        System.out.println("Cliente: " + pedido.cliente);
        System.out.println("Endereço de Origem: " + pedido.endOrigem);
        System.out.println("Endereço de Destino: " + pedido.endDestino);
        System.out.println("Peso: " + pedido.peso);
        System.out.println("Distância Estimada: " + pedido.distanciaEstimada);
        System.out.println("Modalidade: " + pedido.modalidade.getClass().getSimpleName());
        System.out.println("Custo Estimado: " + pedido.calculaCusto());
        System.out.println("Prazo Estimado: " + pedido.calculaPrazo());
    }

}

