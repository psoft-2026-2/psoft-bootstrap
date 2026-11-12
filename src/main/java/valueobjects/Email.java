package valueobjects;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public final class Email {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    private final String endereco;

    public Email(String endereco) {
        if (!isValid(endereco)) {
            throw new IllegalArgumentException("E-mail inválido: " + endereco);
        }

        this.endereco = endereco.trim().toLowerCase(Locale.ROOT);
    }

    public static boolean isValid(String endereco) {
        if (endereco == null || endereco.isBlank()) {
            return false;
        }
        String limpo = endereco.trim();
        // RFC 5321 define o tamanho máximo total de um e-mail em 254 caracteres
        if (limpo.length() > 254) {
            return false;
        }
        return EMAIL_PATTERN.matcher(limpo).matches();
    }

    public String getEndereco() {
        return endereco;
    }

    public String getUsuario() {
        return endereco.substring(0, endereco.indexOf('@'));
    }

    public String getDominio() {
        return endereco.substring(endereco.indexOf('@') + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Email email = (Email) o;
        return Objects.equals(endereco, email.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }

    @Override
    public String toString() {
        return endereco;
    }
}