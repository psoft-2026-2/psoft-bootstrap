import java.util.HashMap;

public class Crud {

    private HashMap<String, Pessoa> funcionarios = new HashMap<>();
    private HashMap<String, Pessoa> clientes = new HashMap<>();

    public String cadastraPessoa(String nome, int idade, String endereco, String cpf,
                                  String telefone, String profissao, String tipo) {

        if (funcionarios.containsKey(cpf) || clientes.containsKey(cpf)) {
            return "Já existe uma pessoa cadastrada com esse CPF";
        }

        Pessoa pessoa = new Pessoa(nome, idade, endereco, cpf, telefone, profissao);

        if (tipo.equalsIgnoreCase("funcionario")) {
            funcionarios.put(cpf, pessoa);
        } else if (tipo.equalsIgnoreCase("cliente")) {
            clientes.put(cpf, pessoa);
        } else {
            return "Tipo inválido. Use 'cliente' ou 'funcionario'";
        }

        return "Pessoa cadastrada com sucesso";
    }

    public boolean checaFuncionario(String cpf) {
        return funcionarios.containsKey(cpf);
    }

    public boolean checaCliente(String cpf) {
        return clientes.containsKey(cpf);
    }

    private Pessoa buscaPessoa(String cpf) {
        if (checaFuncionario(cpf)) return funcionarios.get(cpf);
        if (checaCliente(cpf)) return clientes.get(cpf);
        return null;
    }

    public Pessoa retornaPessoa(String cpf) {
        return buscaPessoa(cpf);
    }

    public String adicionaEndereco(String cpf, String endereco) {
        Pessoa pessoa = buscaPessoa(cpf);
        if (pessoa == null) return "Pessoa não encontrada";
        pessoa.addEndereco(endereco);
        return "Endereço adicionado com sucesso";
    }

    public String listaClientes() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : clientes.values()) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public String listaFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : funcionarios.values()) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public String trocaFuncao(String cpf) {
        if (checaCliente(cpf)) {
            Pessoa pessoa = clientes.remove(cpf);
            funcionarios.put(cpf, pessoa);
            return "Cliente agora é funcionário";
        } else if (checaFuncionario(cpf)) {
            Pessoa pessoa = funcionarios.remove(cpf);
            clientes.put(cpf, pessoa);
            return "Funcionário agora é cliente";
        }
        return "Pessoa não encontrada";
    }

    public String altOutraInformacao(String cpf, String atributo, String novoValor) {
        Pessoa pessoa = buscaPessoa(cpf);
        if (pessoa == null) return "Pessoa não encontrada";

        switch (atributo.toLowerCase()) {
            case "telefone":
                pessoa.setTelefone(novoValor);
                break;
            case "profissao":
                pessoa.setProfissao(novoValor);
                break;
            case "idade":
                pessoa.setIdade(Integer.parseInt(novoValor));
                break;
            default:
                return "Atributo inválido";
        }
        return "Informação atualizada com sucesso";
    }

    public String editaCliente(String cpf, String atributo, String novoValor) {
        return altOutraInformacao(cpf, atributo, novoValor);
    }

    public String deletaUsuario(String cpf) {
        if (funcionarios.remove(cpf) != null) return "Funcionário removido";
        if (clientes.remove(cpf) != null) return "Cliente removido";
        return "Pessoa não encontrada";
    }
}