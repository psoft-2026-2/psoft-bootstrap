package mercado;

import java.util.Objects;

public class Cliente {

    private String nome;
    private String cpf;
    private TipoCliente tipo;

    public Cliente(String nome, String cpf, TipoCliente tipo) {
        this.tipo = tipo;
        this.nome = nome;
        this.cpf = cpf;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return Objects.equals(this.cpf, outro.cpf);
    }

}
