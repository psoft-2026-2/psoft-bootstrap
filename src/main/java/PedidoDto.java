import Modalidades.Modalidade;

/**
 * PedidoDto
 */
public record PedidoDto (
    Cliente cliente,
    Endereco endOrigem,
    Endereco endDestino,
    Float peso,
    Float distanciaEstimada,
    Modalidade modalidade
){}
