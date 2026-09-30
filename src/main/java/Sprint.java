package main.java;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Sprint {
    private int num;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Colaborador> listColaboradoresTemporarios;

    public Sprint(int num, LocalDate dataInicio, LocalDate dataFim) {
        this.num = num;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.listColaboradoresTemporarios = new ArrayList<>();
    }

    public void adicionarColaboradorTemporario(Colaborador colaborador) {
        this.listColaboradoresTemporarios.add(colaborador);
    }

    public int getNum() { return num; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public List<Colaborador> getListColaboradoresTemporarios() { return listColaboradoresTemporarios; }
}