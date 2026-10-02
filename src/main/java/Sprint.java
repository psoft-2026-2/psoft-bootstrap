

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Sprint {

    private String id;
    private LocalDate deadline;
    private Produto produto;
    private List<String> backlog = new ArrayList<>();
    private Funcionario lider;

    public Sprint(String id, LocalDate deadline, Produto produto) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id da Sprint não pode ser vazio.");
        }
        if (deadline == null) {
            throw new IllegalArgumentException("Deadline não pode ser nulo.");
        }
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        this.id = id;
        this.deadline = deadline;
        this.produto = produto;
    }

    public Sprint(String id, LocalDate deadline, Produto produto, List<String> backlog) {
        this(id, deadline, produto);
        if (backlog != null) {
            this.backlog.addAll(backlog);
        }
    }

    public Sprint(String id, Date deadline, Produto produto, String[] backlog) {
        this(id, toLocalDate(deadline), produto, backlog == null ? null : List.of(backlog));
    }

    private static LocalDate toLocalDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Deadline não pode ser nulo.");
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getId() {
        return id;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Date getDeadlineAsDate() {
        return Date.from(deadline.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Deadline não pode ser nulo.");
        }
        this.deadline = deadline;
    }

    public Produto getProduto() {
        return produto;
    }

    public List<String> getBacklog() {
        return Collections.unmodifiableList(backlog);
    }

    public String[] getBacklogArray() {
        return backlog.toArray(String[]::new);
    }

    public void setBacklog(String[] backlog) {
        setBacklog(backlog == null ? null : List.of(backlog));
    }

    public void setBacklog(List<String> backlog) {
        this.backlog.clear();
        if (backlog != null) {
            this.backlog.addAll(backlog);
        }
    }

    public void addBacklogItem(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException("Item do backlog não pode ser vazio.");
        }
        backlog.add(item);
    }

    public void removeBacklogItem(String item) {
        backlog.remove(item);
    }

    public Funcionario getLider() {
        return lider;
    }

    public void definirLider(Funcionario desenvolvedor) {
        if (desenvolvedor == null) {
            throw new IllegalArgumentException("Líder não pode ser nulo.");
        }
        if (!desenvolvedor.isDesenvolvedor()) {
            throw new IllegalArgumentException("O líder temporário deve ser um desenvolvedor.");
        }
        if (!produto.getTime().possuiDesenvolvedor(desenvolvedor)) {
            throw new IllegalArgumentException("O líder deve pertencer ao time do produto.");
        }
        this.lider = desenvolvedor;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Sprint other && id.equals(other.id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id='" + id + '\'' +
                ", deadline=" + deadline +
                ", produto=" + produto.getNome() +
                ", lider=" + (lider == null ? null : lider.getNome()) +
                '}';
    }
}
