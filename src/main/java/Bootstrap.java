public class Bootstrap {
    Pessoa pessoa;
    public static void main(String[] args) {
        
        System.out.println("Projeto de Software");
        
    }
    public static void Create_Person(String nome, String CPF, Integer idade, String telefone,string[] ENDERECO, string profissao){
        Pessoa pessoa = new Pessoa(nome, CPF, idade, telefone, ENDERECO, profissao);
    }
}
