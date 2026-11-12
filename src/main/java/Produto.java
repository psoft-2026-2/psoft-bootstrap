public class Produto {
    private Integer id;
    private Double preco;
    private String descricao;

    public Produto(Integer id, Double preco, String descricao) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Integer getId() { 
        return id;
    }

    public void setId(Integer id) { 
        this.id = id; 
    }

    public Double getPreco() { 
        return preco; 
    }

    public void setPreco(Double preco) { 
        this.preco = preco; 
    }

    public String getDescricao() { 
        return descricao; 
    }
    
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
}