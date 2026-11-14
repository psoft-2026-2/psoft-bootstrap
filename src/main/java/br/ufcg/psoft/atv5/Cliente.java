package br.ufcg.psoft.atv5;

public class Cliente {
    private final String nome;
    private final String documento;

    public Cliente(String nome, String documento) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento do cliente é obrigatório.");
        }
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}
