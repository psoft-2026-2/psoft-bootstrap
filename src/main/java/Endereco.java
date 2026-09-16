public class Endereco {
	public Endereco(String cep, String rua) {
		this.cep = cep;
		this.rua = rua;
	}
	String cep;
	String rua;
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", rua=" + rua + "]";
	}
}
