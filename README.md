# Projeto de Software — Atividade 2

Implementação em Java do sistema de empresa, produtos, times e Sprints apresentado no enunciado e no UML da atividade.

## Executar

Requisito: JDK 17 ou superior, com `java` e `javac` disponíveis no terminal. O projeto usa apenas a biblioteca padrão, sem dependências externas.

Na raiz do repositório, execute no PowerShell:

```powershell
New-Item -ItemType Directory -Force build/classes | Out-Null
javac -encoding UTF-8 --release 17 -d build/classes src/main/java/*.java
java "-Dstdout.encoding=UTF-8" -cp build/classes Bootstrap
```

O exemplo cria uma empresa, um produto, um time e dois desenvolvedores. Ana lidera a primeira Sprint; Bruno lidera a segunda. Depois, Ana assume a gerência e o gerente anterior é promovido a Product Owner. A saída mostra os papéis antes e depois de cada mudança.

## Testar

Os testes são executáveis pelo próprio Java e lançam `AssertionError` se uma verificação falhar. Não é necessário habilitar `-ea` ou instalar JUnit.

```powershell
New-Item -ItemType Directory -Force build/test-classes | Out-Null
javac -encoding UTF-8 --release 17 -d build/test-classes src/main/java/*.java src/test/java/*.java
java "-Dstdout.encoding=UTF-8" -cp build/test-classes SistemaTest
```

Os cenários verificam alternância e encerramento da liderança, preservação do histórico, promoções, associações, listas imutáveis e rejeição de operações inválidas sem alterar o estado anterior.

## Correspondência com o UML

| Elemento | Responsabilidade na implementação |
| --- | --- |
| `Empresa` | Nome, produtos e um Product Owner que supervisiona todos os seus produtos. |
| `Produto` | Nome, descrição, gerente e vínculos com a empresa e o time responsável. |
| `Time` | Um produto, um gerente, desenvolvedores e Sprints; oferece os métodos de inclusão, remoção e definição de gerente do UML. |
| `Sprint` | Número, início, fim e definição de líder; acessa os desenvolvedores por meio do time. |
| `Funcionario` | Nome e composição de papéis; adiciona, remove, consulta e delega promoções. |
| `Papel` | Interface com `getNome()` e `getResponsabilidades()`. |
| `PapelDesenvolvedor`, `PapelLider`, `PapelGerente`, `PapelProductOwner` | Implementações das quatro funções. |
| `Promocao` | Interface com `aplicar(Funcionario)`. |
| `PromocaoGerente`, `PromocaoProductOwner` | Estratégias para as duas promoções previstas. |

`Funcionario` contém objetos `Papel` e utiliza uma estratégia `Promocao` em `promover`. As classes `PromocaoGerente` e `PromocaoProductOwner` implementam a interface `Promocao`. O funcionário não implementa essa interface: ele é a pessoa sobre a qual a estratégia atua.

## Regras e decisões de implementação

- Um funcionário começa como desenvolvedor no construtor `Funcionario(nome)`. Também é possível informar um papel inicial para cadastrar o gerente ou Product Owner já existente.
- Um desenvolvedor pode acumular o papel de líder. Gerente e Product Owner exercem somente seu próprio papel. Não se permite duplicar papéis ou remover o último papel de um funcionário.
- O líder deve ser desenvolvedor do próprio time e diferente do líder da Sprint anterior. Ele pode voltar a liderar depois de uma Sprint liderada por outra pessoa. O papel de líder só pode ser atribuído por uma Sprint aberta do time.
- `Time.iniciarSprint(...)` cria uma Sprint já com líder. Depois de validar todos os dados, encerra a anterior e transfere a liderança. `Sprint.definirLider(...)` permite trocar o líder durante a Sprint, mantendo a alternância em relação à anterior.
- `Sprint.encerrar()` remove o papel temporário de líder e preserva a referência à pessoa que liderou. O histórico continua acessível mesmo se essa pessoa for promovida. Os desenvolvedores consultados em `Sprint.getDesenvolvedores()` são os membros atuais do time, sem um histórico de participantes.
- A promoção de um desenvolvedor vinculado a um time torna essa pessoa o gerente desse time, retira-a dos desenvolvedores e desvincula o gerente anterior. Um líder de Sprint aberta precisa ser substituído ou encerrar a Sprint antes da promoção ou remoção.
- Para promover um gerente vinculado a Product Owner, primeiro atribua um substituto ao time. Isso pode ocorrer com `Time.definirGerente(...)` ou promovendo um desenvolvedor do time. Depois, use `gerenteAnterior.promover(new PromocaoProductOwner())` e `empresa.definirProductOwner(gerenteAnterior)`. Assim o time mantém um gerente, e a empresa mantém um único Product Owner.
- Um produto pertence a apenas uma empresa e tem apenas um time. Um funcionário só pode estar vinculado a um time por vez. O gerente fica associado ao produto, conforme o desenho; `Time.getGerente()` consulta essa mesma referência.
- O cadastro é construído em etapas: crie o produto, seu time com gerente e então adicione o produto à empresa. Os desenvolvedores são incluídos pelos métodos do time; iniciar uma Sprint exige um desenvolvedor elegível para liderá-la.
- As datas usam `LocalDate`, equivalente ao `Date` do desenho para datas sem horário. Os números das Sprints são positivos e crescentes por time; o fim não pode anteceder o início, e as datas de Sprints consecutivas não podem se sobrepor. As datas finais são inclusivas.
- O encerramento é explícito ou ocorre ao iniciar a próxima Sprint; não depende do relógio do computador. Coleções são expostas como cópias imutáveis para preservar as regras das classes.

## Entrega

O enunciado indica a branch `psoft-atv2`, um pull request dessa branch para a `main` do repositório original e o preenchimento do formulário da atividade com as informações da entrega.
