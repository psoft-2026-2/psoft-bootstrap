public class Endereco {
    
    private String rua;
    private String bairro;
    private String cidade;
    private String num_apartamento;
	
    public Endereco(String rua, String bairro, String cidade, String num_apartamento) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.num_apartamento = num_apartamento;
	}

	@Override
	public String toString() {
		return "Rua " + rua + ", " + num_apartamento + ", " + bairro + ", " + cidade;
	}

}