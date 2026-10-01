public class Bootstrap {

    public static void main(String[] args) {

        System.out.println("Projeto de Software");

        Funcionario po = new Funcionario("1", "Ana");
        Empresa empresa = new Empresa("Acme", po);

        Funcionario gerente = new Funcionario("2", "Bruno");
        Funcionario dev = new Funcionario("3", "Carla");

        empresa.adicionarTime("t1", "Time Alpha", gerente);
        Time time = empresa.getTimes().get("t1");
        time.adicionarMembro(dev);
        time.atribuirProduto(new Produto("App", "Aplicativo mobile"));
        time.adicionarSprint("Sprint 1", dev);

        System.out.println(dev.getNome() + " é líder? " + dev.possuiPapel(Lider.class));
        time.getSprints().get(0).encerrar();
        System.out.println(dev.getNome() + " é líder? " + dev.possuiPapel(Lider.class));
        System.out.println(gerente.getNome() + " é gerente? " + gerente.possuiPapel(Gerente.class)
                + ", dev? " + gerente.possuiPapel(Dev.class));

        gerente.promover(new ProductOwner(empresa));
        System.out.println(gerente.getNome() + " é PO? " + gerente.possuiPapel(ProductOwner.class));
    }
}
