# Sistema de gerenciamento de entregas — Atividade 5

Implementação em Java do UML da atividade, usando os padrões **Strategy** e **Singleton**.

## Estrutura

- `EstrategiaEntrega` define as operações comuns de cálculo. `EntregaConvencional`, `EntregaExpressa` e `EntregaEconomica` implementam as políticas; `ModalidadeEntrega` e as classes `Modalidade...` permanecem como aliases para os nomes do projeto-base.
- `Pedido` mantém cliente, endereços, peso, distância, modalidade escolhida, custo, prazo estimado e status.
- `CentralDeLogistica` tem construtor privado e acesso por `getInstance()`. Ela registra e acompanha pedidos e delega a seleção de modalidade ao pedido.
- A modalidade pode ser trocada enquanto o pedido está `REGISTRADO`. Depois do despacho, a troca é recusada.
- Os prazos estimados são expressos em **horas**. As faixas de distância (até 10 km, até 100 km e acima de 100 km) seguem o esqueleto do projeto-base.

## Políticas de cálculo

Os valores comerciais não foram fixados no enunciado; por isso cada estratégia recebe seus parâmetros no construtor e também oferece valores padrão de exemplo:

- Convencional: `taxaFixa + valorPorKm * distância`.
- Expressa: `taxaBase * distância + taxaPrioridade`.
- Econômica: `taxaBase * distância * (1 - desconto)`, com o desconto como fração (por exemplo, `0.20` representa 20%).

O `Bootstrap` demonstra o cadastro de um pedido, a troca da estratégia antes do despacho e o início do acompanhamento.

## Compilar, testar e executar

Requer JDK 8 ou superior. No PowerShell, na raiz deste repositório:

```powershell
$arquivos = Get-ChildItem -Path "src/main/java", "src/test/java" -Recurse -Filter "*.java" | ForEach-Object { $_.FullName }
New-Item -ItemType Directory -Force -Path "out" | Out-Null
javac -encoding UTF-8 -d out $arquivos
java -cp out Atividade5Test
java -cp out Bootstrap
```
