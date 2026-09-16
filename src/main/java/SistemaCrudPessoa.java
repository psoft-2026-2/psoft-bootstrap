import java.util.HashMap;
import java.util.Map;

public class SistemaCrudPessoa {

	private Map<String, Pessoa> usuarios;
	
	public SistemaCrudPessoa() {
		this.usuarios = new HashMap<String, Pessoa>();
	}
	
	public boolean addCliente(String nome, String cpf, String telefone, String profissao, int idade) {
		Pessoa usuario = new Cliente(nome, cpf, telefone, profissao,idade);
		usuarios.put(cpf, usuario);
		return true;
	}
	
	public boolean addFuncionario(String nome, String cpf, String telefone, String profissao, int idade, double salario) {
		Pessoa usuario = new Funcionario(nome, cpf, telefone, profissao, idade, salario);
		usuarios.put(cpf, usuario);
		return true;
	}
	
	public boolean addEndereco(String cpf, String endereco) {
		Pessoa usuario = this.usuarios.get(cpf);
		usuario.addEndereco(endereco);
		return true;
	}
	
	public boolean removeUsuario(String cpf) {
		if (!this.usuarios.containsKey(cpf)) return false;
		this.usuarios.remove(cpf);
		return true;
	}
	
	public String listaUsuarios() {
		String output = "";
		
		for (Pessoa usuario : this.usuarios.values()) {
			output += (usuario.toString() + "\n");
		}
		
		return output;
	}
	
}
