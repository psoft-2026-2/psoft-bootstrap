import java.lang.ModuleLayer.Controller;

import controller.PessoaController;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pessoa;

public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        PessoaController controller =  new  PessoaController();

        Endereco end1 = new Endereco("Rua das flores", 100, "malvinas", "Campina Grande"); 
        Endereco end2 = new Endereco("Rua das maravilhosa", 200, "lagoa", "Logoa Seca");
        
        Cliente cliente = new  Cliente("Lucas", "12345678910", "99378521", "TI", "20"); 
        cliente.adicionarEndereco(end1);
        cliente.adicionarEndereco(end2);
        controller.cadastrar(cliente);

        Funcionario funcionario = new  Funcionario("Ricardo", "234564476", "8455-4545", "Faxineiro", "12421180545");
        funcionario.adicionarEndereco(end2);
        controller.cadastrar(funcionario);

        for (Pessoa p : controller.listar()){
            System.out.println("Nome:"+  p.getNome());

        }

         boolean atualizar = controller.atualizar("234564476", "15445545", "TI"); 
         if (atualizar){
            System.out.println("Cadastro atualizado,com sucesso!");
         }
         boolean deletou = controller.deletar("12345678910"); 

         if (deletou){
            System.out.println("Deletou com sucesso!");
         }
        System.out.println("\n--- Lista Final de Pessoas ---");
        for (Pessoa p : controller.listar()) {
            System.out.println("Nome: " + p.getNome() + " | | Profissão: " + p.getCargo());
        }
    }
}
