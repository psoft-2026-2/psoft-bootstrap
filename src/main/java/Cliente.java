public class Cliente {
	private Integer id;
	private String nome;
	private Categoria categoria;
	
	Cliente(String nome) {
		this.id = nome.hashCode();
		this.nome = nome;
		this.categoria = Categoria.Standart;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//Faltaram esses métodos no diagrama
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
