import java.time.LocalDate;

public class Sprint {
    private final LocalDate dataInicio;
    private LocalDate limite;
    private String descricao;
    private final int numero;
    private Funcionario lider;

    public Sprint(LocalDate dataInicio, LocalDate limite, String descricao, int numero, Funcionario lider) {
        this.dataInicio = dataInicio;
        this.limite = limite;
        this.descricao = descricao;
        this.numero = numero;
        this.lider = lider;
    }

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public LocalDate getLimite() {
		return limite;
	}

	public void setLimite(LocalDate limite) {
		this.limite = limite;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public Funcionario getLider() {
		return lider;
	}

	public void setLider(Funcionario lider) {
		this.lider = lider;
	}

}
