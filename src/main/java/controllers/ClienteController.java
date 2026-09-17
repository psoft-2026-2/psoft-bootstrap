package controllers;
import java.util.ArrayList;
import java.util.List;
import pessoa.Cliente;

public class ClienteController {

    private List<Cliente> clientes;

    public ClienteController(){
        this.clientes = new ArrayList<>();
    }

    public void criarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCpf()) == null) {
            clientes.add(cliente);
        }
    }

    public Cliente buscarCliente(String cpf) {
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equalsIgnoreCase(cpf)) {
                cliente = c;
            }
        }
        return cliente;
    }

    public void atualizarCliente(String cpf, int novaIdade, String novoTelefone, String novaProfissao) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            cliente.setIdade(novaIdade);
            cliente.setTelefone(novoTelefone);
            cliente.setProfissao(novaProfissao);
        }
    }

    public void deletarCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }
}