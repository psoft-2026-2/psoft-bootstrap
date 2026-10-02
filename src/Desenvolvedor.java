public class Desenvolvedor implements Papel {
    private String nome;
    private String idMembro;
    private String linguagens;

    public Desenvolvedor(String nome, String idMembro, String linguagens) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.linguagens = linguagens;
    }

    public String getLinguagens() {
        return linguagens;
    }
    
    public String getNome() {
        return nome;
    }

    public String getIdMembro() {
        return idMembro;
    }
}