public class Bootstrap {
    public static void main(String[] args) {
        PessoaCRUD crud = new PessoaCRUD();

        Pessoa reimu = new Pessoa(
            "Reimu Hakurei",
            17,
            "096.000.001-00",
            "00000000001",
            new Profissao("Sacerdotisa Hakurei"),
            Papel.FUNCIONARIO
        );
        reimu.adicionarEndereco(
            new Endereco(
                "Santuário Hakurei",
                "Montanha Hakurei",
                "Gensokyo",
                "00000-000"
            )
        );
        crud.criar(reimu);

        Pessoa marisa = new Pessoa(
            "Marisa Kirisame",
            17,
            "096.000.002-00",
            "00000000002",
            new Profissao("Maga"),
            Papel.CLIENTE
        );
        marisa.adicionarEndereco(
            new Endereco(
                "Floresta da Magia",
                "Centro",
                "Gensokyo",
                "00000-002"
            )
        );
        crud.criar(marisa);


        Pessoa sakuya = new Pessoa(
            "Sakuya Izayoi",
            20,
            "096.000.003-00",
            "00000000003",
            new Profissao("Maid"),
            Papel.FUNCIONARIO
        );
        sakuya.adicionarEndereco(
            new Endereco(
                "Mansão Scarlet",
                "Mist Lake",
                "Gensokyo",
                "00000-003"
            )
        );
        crud.criar(sakuya);


        System.out.println("TODAS AS PESSOAS");
        for (Pessoa pessoa : crud.listar()) {
            System.out.println(pessoa);
        }

        System.out.println("\nBUSCANDO REIMU");
        Pessoa encontrada = crud.buscar("096.000.001-00");
        System.out.println(encontrada);

        System.out.println("\nATUALIZANDO MARISA");
        crud.atualizar(
            "096.000.002-00",
            18,
            "00000000022",
            new Profissao("Maga"),
            Papel.FUNCIONARIO
        );

        System.out.println(crud.buscar("096.000.002-00"));

        System.out.println("\nREMOVENDO SAKUYA");
        crud.remover("096.000.003-00");

        System.out.println("\nPESSOAS APÓS REMOÇÃO");
        for (Pessoa pessoa : crud.listar()) {
            System.out.println(pessoa);
        }
    }
}