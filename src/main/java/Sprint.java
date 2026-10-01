import java.util.Objects;

public class Sprint {
    private int id;
    private String descricao;
    private Lider lider;

    public Sprint(String descricao, Lider lider) {
        this.descricao = descricao;
        this.lider = lider;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Lider getLider() {
        return lider;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
        Sprint other = (Sprint) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao ;
    }
}
