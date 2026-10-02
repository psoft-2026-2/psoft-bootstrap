public class Bootstrap {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        System.out.println("===== CONTRATAÇÃO =====");

        empresa.contratar(
                "Ana",
                "111",
                3500
        );

        empresa.contratar(
                "Bruno",
                "222",
                4000
        );

        empresa.contratar(
                "Carlos",
                "333",
                4500
        );

        empresa.contratar(
                "Daniela",
                "444",
                5000
        );

        System.out.println();

        empresa.listarFuncionarios();


        System.out.println();
        System.out.println(
                "===== PROMOÇÃO PARA GERENTE ====="
        );

        empresa.promover("333");

        System.out.println(
                empresa.getFuncionario("333")
        );


        System.out.println();
        System.out.println(
                "===== CRIAÇÃO DO PROJETO ====="
        );

        empresa.criarProjeto(
                "P001",
                "333",
                "Sistema de gerenciamento de projetos"
        );


        System.out.println();
        System.out.println(
                "===== TIME DO PROJETO ====="
        );

        empresa.addDesenvolvedorEmProjeto(
                "111",
                "P001"
        );

        empresa.addDesenvolvedorEmProjeto(
                "222",
                "P001"
        );

        empresa.addDesenvolvedorEmProjeto(
                "444",
                "P001"
        );

        empresa.listarTimeDeProjeto("P001");

        System.out.println();
        System.out.println(
                "===== SPRINTS ====="
        );

        empresa.criarSprint(
                "111",
                "P001",
                "Sprint 1 - Levantamento de requisitos"
        );

        empresa.criarSprint(
                "222",
                "P001",
                "Sprint 2 - Desenvolvimento"
        );

        empresa.criarSprint(
                "444",
                "P001",
                "Sprint 3 - Testes e entrega"
        );

        empresa.sprintsDeProjeto("P001");

        System.out.println();
        System.out.println(
                "===== PRODUCT OWNER ====="
        );

        empresa.elegerProductOwner("333");

        System.out.println(
                "Product Owner: " +
                empresa.getProductOwner()
        );


        System.out.println();
        System.out.println(
                "===== AUMENTO ====="
        );

        empresa.darAumento(
                "111",
                500
        );

        System.out.println(
                empresa.getFuncionario("111") +
                " | salário = " +
                empresa.getFuncionario("111")
                        .getSalario()
        );


        System.out.println();
        System.out.println(
                "===== ENTREGA DO PROJETO ====="
        );

        empresa.entregarProjeto("P001");

        empresa.listarProjetos();
    }
}