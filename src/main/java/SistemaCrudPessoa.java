import java.util.HashMap;
import java.util.Map;

public class SistemaCrudPessoa {

	private Map<String, Pessoa> usuarios;

	public SistemaCrudPessoa() {
		this.usuarios = new HashMap<String, Pessoa>();
	}

	public boolean addCliente(String nome, String cpf, String telefone, String profissao, int idade) {
		if (vazio(nome)) return false;
		if (vazio(cpf)) return false;
		if (vazio(telefone)) return false;
		if (vazio(profissao)) return false;
		if (idade < 0) return false;
		if (usuarios.containsKey(cpf)) return false;

		Pessoa usuario = new Cliente(nome, cpf, telefone, profissao,idade);
		usuarios.put(cpf, usuario);
		return true;
	}

	public boolean addFuncionario(String nome, String cpf, String telefone, String profissao, int idade, double salario) {
		if (vazio(nome)) return false;
		if (vazio(cpf)) return false;
		if (vazio(telefone)) return false;
		if (vazio(profissao)) return false;
		if (idade < 0) return false;
		if (salario < 0) return false;
		if (usuarios.containsKey(cpf)) return false;

		Pessoa usuario = new Funcionario(nome, cpf, telefone, profissao, idade, salario);
		usuarios.put(cpf, usuario);
		return true;
	}

	public boolean addEndereco(String cpf, String endereco) {
		if (vazio(endereco)) return false;

        Pessoa usuario = this.usuarios.get(cpf);

        if (usuario == null) return false;

		usuario.addEndereco(endereco);
		return true;
	}

	public boolean removeEndereco(String cpf, String endereco) {
		if (vazio(endereco)) return false;

        Pessoa usuario = this.usuarios.get(cpf);

        if (usuario == null) return false;

		return usuario.removeEndereco(endereco);
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

    public String listaUsuario(String cpf) {
        Pessoa usuario = this.usuarios.get(cpf);

        if (usuario == null) return null;

        return this.usuarios.get(cpf).toString();
    }

	public boolean addCompra(String cpf, String id, String compra) {
		if (vazio(id)) return false;
		if (vazio(compra)) return false;

        Pessoa usuario = this.usuarios.get(cpf);

        if (!(usuario instanceof Cliente)) return false;

		((Cliente) usuario).addCompra(id, compra);
		return true;
	}

	public String getCompra(String cpf, String id) {
        Pessoa usuario = this.usuarios.get(cpf);

        if (!(usuario instanceof Cliente)) return null;

		return ((Cliente) usuario).getCompra(id);
	}

	public boolean incrementaVendas(String cpf, double valor) {
		if (valor < 0) return false;

        Pessoa usuario = this.usuarios.get(cpf);

        if (!(usuario instanceof Funcionario)) return false;

		((Funcionario) usuario).incrementaVendas(valor);
		return true;
	}

	public boolean setSalario(String cpf, double salario) {
		if (salario < 0) return false;

        Pessoa usuario = this.usuarios.get(cpf);

        if (!(usuario instanceof Funcionario)) return false;

		((Funcionario) usuario).setSalario(salario);
		return true;
	}

	private boolean vazio(String s) {
		return s == null || s.trim().isEmpty();
	}

}
