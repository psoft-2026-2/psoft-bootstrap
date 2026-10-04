public class CPF {
    private String valor;

    public CPF(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        this.valor = valor.replaceAll("\\D", "");
    }

    public String getValor() {
        return valor;
    }

    public String getFormatado() {
        if (valor.length() == 11) {
            return valor.substring(0, 3) + "." + valor.substring(3, 6) + "." +
                   valor.substring(6, 9) + "-" + valor.substring(9);
        }
        return valor;
    }
}