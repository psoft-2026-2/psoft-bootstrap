# Atividade 1.2 - Projeto de Software (2026.2)
**Universidade Federal de Campina Grande (UFCG)**  
**Curso:** Ciência da Computação  
**Disciplina:** Projeto de Software  
**Aluna:** Mariana Barros e Moraes Sabino  
**Matrícula:** 124211050

---

## Enunciado da Atividade

### Parte 1 - Modelagem (Em sala)
Considerando os padrões **GRASP** (*Information Expert*, *Creator*, *Low Coupling* e *High Cohesion*), desenvolva um projeto de sistema (não utilize *controllers*, *services* e *repositories*) para um mercado que permita a venda de produtos a partir de um pagamento. 

**Regras de Negócio:**
- Os valores dos itens a serem vendidos dependem da quantidade de produtos de cada item de venda. 
- **Desconto de Quantidade:** Itens com 20 ou mais produtos recebem **10% de desconto** no seu preço.
- **Desconto de Assinatura:** O valor total da venda pode receber um desconto em função do perfil de assinatura do cliente (`STANDARD` ou `PREMIUM`). Clientes com perfil `PREMIUM` recebem um **desconto adicional de 5%** na compra.

---

### Parte 2 - Implementação (Em Java)
Desenvolver, em Java, o sistema projetado a partir da branch `psoft-atv1-2`.

**Passos executados:**
1. Fork do repositório oficial `psoft-bootstrap`.
2. Criação da branch `psoft-atv1-2` para o desenvolvimento.
3. Implementação do modelo do domínio respeitando as atribuições de responsabilidade GRASP.
4. Abertura do Pull Request para a branch `main` do repositório original.

---

## Estrutura do Projeto

A solução foi modelada sem a utilização de camadas de serviço ou persistência (*controllers*, *services*, *repositories*), mantendo a lógica de negócio encapsulada diretamente nas classes de domínio:

- **`Assinatura`** *(Enum)*: Define os perfis `STANDARD` e `PREMIUM`.
- **`StatusPagamento`** *(Enum)*: Define os status da transação (`PENDENTE`, `APROVADO`, `RECUSADO`).
- **`Cliente`**: Mantém dados do cliente e seu perfil de assinatura.
- **`Produto`**: Identificação e preço unitário dos produtos.
- **`ItemVenda`**: *Information Expert* para calcular o subtotal do item, aplicando os 10% de desconto quando a quantidade é $\ge 20$.
- **`Pagamento`**: Registra a forma de pagamento, o valor fornecido e o `StatusPagamento`.
- **`NotaFiscal`**: *Creator* para `ItemVenda` e *Information Expert* para calcular o valor total da venda (aplicando o desconto de 5% para clientes `PREMIUM`) e processar o pagamento alterando o seu status.
- **`Mercado`**: Entidade agregadora para cadastro e busca de clientes, produtos e notas fiscais.
