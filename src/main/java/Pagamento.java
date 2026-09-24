import java.util.UUID;

public class Pagamento {

    private final String id;
    private final double valor;
    private final FormaPag formaPag;
    private Status status;

    public Pagamento(double valor, FormaPag formaPag) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor do pagamento não pode ser negativo");
        }
        if (formaPag == null) {
            throw new IllegalArgumentException("Forma de pagamento não pode ser nula");
        }
        this.id = UUID.randomUUID().toString();
        this.valor = valor;
        this.formaPag = formaPag;
        this.status = Status.EM_ANDAMENTO;
    }

    public String getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public FormaPag getFormaPag() {
        return formaPag;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }
        this.status = status;
    }
}