package controller;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;

public class ClienteController {

    private List<Cliente> clientes;


    public ClienteController() {
        this.clientes = new ArrayList<Cliente>();
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void criarCliente(String nome, String cpf, int idade, String telefone, String endereco, String profissao) {
        Cliente cliente = new Cliente(nome, cpf, idade, telefone, endereco, profissao);
        adicionarCliente(cliente);
    }

    public boolean deletarCliente(Cliente cliente) {
        return this.clientes.remove(cliente);
    }
    
}
