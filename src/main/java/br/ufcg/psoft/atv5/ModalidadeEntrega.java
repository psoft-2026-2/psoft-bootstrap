package br.ufcg.psoft.atv5;

/**
 * Strategy: cada modalidade de entrega define sua própria política de
 * cálculo de custo e prazo. Novas modalidades são adicionadas criando
 * novas implementações, sem alterar as existentes (Open/Closed).
 */
public interface ModalidadeEntrega {

    /** Custo da entrega, em reais. */
    double calcularCusto(Pedido pedido);

    /** Prazo estimado da entrega, em dias. */
    double calcularPrazo(Pedido pedido);
}
