package logistica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacao {

    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String descricao;
    private LocalDateTime momento;

    public Operacao(String descricao) {
        this(descricao, LocalDateTime.now());
    }

    public Operacao(String descricao, LocalDateTime momento) {
        this.descricao = descricao;
        this.momento = momento == null ? LocalDateTime.now() : momento;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    @Override
    public String toString() {
        return formato.format(momento) + " - " + descricao;
    }
}
