public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        Empresa empresa = new Empresa();

        // 2. Criar e adicionar Desenvolvedores na Empresa
        Funcionario dev1 = new Funcionario("111.222.333-44", new Desenvolvedor(), "Ana Silva");
        Funcionario dev2 = new Funcionario("555.666.777-88", new Desenvolvedor(), "Carlos Oliveira");
        Funcionario gerenteFunc = new Funcionario("999.888.777-66", new Desenvolvedor(), "Beatriz Lima");
        Funcionario poFunc = new Funcionario("000.111.222-33", new Desenvolvedor(), "Lucas Ricardo");

        empresa.addDesenvolvedor(dev1.getCpf(), dev1.getPapel(), dev1.getNome());
        empresa.addDesenvolvedor(dev2.getCpf(), dev2.getPapel(), dev2.getNome());
        empresa.addDesenvolvedor(gerenteFunc.getCpf(), gerenteFunc.getPapel(), gerenteFunc.getNome());

        
        empresa.setProductOwner(poFunc);
        System.out.println("Product Owner da empresa: " + empresa.getProductOwner().getNome() 
                + " (Papel: " + empresa.getProductOwner().getPapel().getClass().getSimpleName() + ")");

       
        Produto produto1 = new Produto("Sistema de Gestão", 101);

        
        
        empresa.addTime(1,gerenteFunc);
        empresa.addProdutoAoTime(1, produto1);

        
        empresa.addDesenvolvedorAoTime(1, dev1);
        empresa.addDesenvolvedorAoTime(1, dev2);

    }
}
