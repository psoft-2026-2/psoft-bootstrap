import java.util.HashSet;
import java.util.Set;

public class Cliente {

    private String nome, cpf;
    private int id;
    private Set<Pedido> pedidos;
    private boolean isPremium;
    
    public Cliente(String nome, String cpf, int id) {
        this.nome = nome;
        this.cpf = cpf;
        this.id = id;

        pedidos = new HashSet<>();
        isPremium = false;

    }

    public void addPedido(Pedido pedido) {pedidos.add(pedido);}

    public Pagamento pagarPedido(Pedido pedido) {
        if (!pedidos.contains(pedido))
            throw new IllegalArgumentException("Pedido " + pedido.getId() + " não pertence a " + nome);
        return new Pagamento(this, pedido);
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public int getId() {return id;}

    public Set<Pedido> getPedidos() {return pedidos;}

    public boolean isPremium() {return isPremium;}

    public void setPremium(boolean isPremium) {this.isPremium = isPremium;}

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cpf=" + cpf + ", isPremium=" + isPremium + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (id != other.id)
            return false;
        return true;
    }
}
