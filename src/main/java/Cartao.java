public class Cartao {
    private String numero;
    private String bandeira;
    private String titular;
    private String secNumero;
}

public Cartao(String numero, String bandeira, String titular, String secNumero) {
    this.numero = numero;
    this.bandeira = bandeira;
    this.titular = titular;
    this.secNumero = secNumero;
}

public String getNumero() {
    return numero;
}

public String getBandeira() {
    return bandeira;
}

public String getTitular() {
    return titular;
}

public String getSecNumero() {
    return secNumero;
}

public void setNumero(String numero) {
    this.numero = numero;
}

public void setBandeira(String bandeira) {
    this.bandeira = bandeira;
}

public void setTitular(String titular) {
    this.titular = titular;
}
public void setSecNumero(String secNumero) {
    this.secNumero = secNumero;
}

