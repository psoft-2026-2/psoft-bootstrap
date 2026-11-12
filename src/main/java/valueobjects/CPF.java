package valueobjects;

import java.util.Objects;

public final class CPF {
    private final String numero;

    public CPF(String num) {
        if (!valida(num)) {
            throw new IllegalArgumentException("CPF inválido: " + num);
        }

        this.numero = removeDigitosNaoNumericos(num);
    }

    public boolean valida(String num) {
        if (num == null) {
            return false;
        }

        String cpfLimpo = removeDigitosNaoNumericos(num);

        // Verifica se tem 11 dígitos ou se todos os dígitos são iguais (ex:
        // 111.111.111-11)
        if (cpfLimpo.length() != 11 || cpfLimpo.matches("(\\d)\\1{10}")) {
            return false;
        }

        int digito1 = calculaPrimeiroDigito(cpfLimpo);

        if (digito1 != Character.getNumericValue(cpfLimpo.charAt(9))) {
            return false;
        }

        int digito2 = calculaSegundoDigito(cpfLimpo);

        return digito2 == Character.getNumericValue(cpfLimpo.charAt(10));
    }

    private String removeDigitosNaoNumericos(String num) {
        return num.replaceAll("\\D", "");
    }

    private int calculaPrimeiroDigito(String cpf) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (10 - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

    private int calculaSegundoDigito(String cpf) {
        int soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * (11 - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

    public String getNumero() {
        return numero;
    }

    public String getNumeroFormatado() {
        return numero.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CPF cpf = (CPF) o;
        return Objects.equals(numero, cpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return getNumeroFormatado();
    }
}