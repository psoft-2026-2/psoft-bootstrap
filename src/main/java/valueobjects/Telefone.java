package valueobjects;

import java.util.Objects;

public final class Telefone {
    private final String ddd;
    private final String numero;

    public Telefone(String num) {
        if (!isValid(num)) {
            throw new IllegalArgumentException("Telefone inválido: " + num);
        }

        String apenasDigitos = removeDigitosNaoNumericos(num);

        this.ddd = apenasDigitos.substring(0, 2);
        this.numero = apenasDigitos.substring(2);
    }

    public boolean isValid(String num) {
        if (num == null) {
            return false;
        }

        String apenasDigitos = removeDigitosNaoNumericos(num);

        // Regra:
        // ^[1-9]{2} -> DDD com 2 dígitos (no Brasil não existem DDDs com dígito 0)
        // 9 -> Nono dígito obrigatório para celulares no Brasil
        // \\d{8}$ -> 8 dígitos restantes
        return apenasDigitos.matches("^[1-9]{2}9\\d{8}$");
    }

    private String removeDigitosNaoNumericos(String num) {
        return num.replaceAll("\\D", "");
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumeroCompleto() {
        return ddd + numero;
    }

    public String getNumeroFormatado() {
        return String.format("(%s) %s-%s",
                ddd,
                numero.substring(0, 5),
                numero.substring(5));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(ddd, telefone.ddd) &&
                Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public String toString() {
        return getNumeroFormatado();
    }
}