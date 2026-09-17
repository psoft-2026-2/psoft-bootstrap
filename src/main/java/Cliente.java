import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Cliente extends Pessoa {

	private Map<String, String> compras;
	
	public Cliente(String nome, String cpf, String telefone, String profissao, int idade) {
		super(nome, cpf, telefone, profissao, idade);
		this.compras = new HashMap<String, String>();
	}
	
	public String addCompra(String id, String compra) {
		return this.compras.put(id, compra);
	}
	
	public List<String> getCompras() {
		return (List<String>) this.compras.values();
	}
	
	public String getCompra(String id) {
		return compras.get(id);
	}
	
}
