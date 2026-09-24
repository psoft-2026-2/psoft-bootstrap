package mercado;
import java.util.*;
public class Cliente {
    private String nome;
    private String cpf;
    private boolean premium;
    private List<Endereco> enderecos;


    public Cliente(String nome, String cpf, boolean premium, List<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.premium = premium;
        this.enderecos = enderecos;
    }

    public boolean isPremium() {
        return this.premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void addEndereco(Endereco endereco){
        if (endereco != null){
            this.enderecos.add(endereco);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
