public class Phone {
    private String numero;
    private String ddd;

    public Phone(String num) {
        if (!isValid(num)) {
            throw new IllegalArgumentException("Telefone inválido. O formato deve ter 11 dígitos (DDD + 9 dígitos).");
        }

        String numeroLimpo = num.replaceAll("\\D", "");
        this.ddd = numeroLimpo.substring(0, 2);
        this.numero = numeroLimpo.substring(2);
    }

    public boolean isValid(String num) {
        if (num == null) {
            return false;
        }

        String numeroLimpo = num.replaceAll("\\D", "");
        return numeroLimpo.length() == 11;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }

    public String getNumeroFormatado() {
        return String.format("(%s) %s-%s",
                this.ddd,
                this.numero.substring(0, 5),
                this.numero.substring(5));
    }
}