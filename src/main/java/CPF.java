public class CPF {
    private String cpf;

    public CPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean validCPF() {
        if (cpf == null) {
            return false;
        }

        String numero = cpf.replaceAll("\\D", "");

        if (numero.length() != 11) {
            return false;
        }

        int digito1 = calcularDigito(numero, 10);
        int digito2 = calcularDigito(numero, 11);

        return digito1 == Character.getNumericValue(numero.charAt(9))
                && digito2 == Character.getNumericValue(numero.charAt(10));
    }

    private int calcularDigito(String numero, int pesoInicial) {
        int soma = 0;
        int peso = pesoInicial;

        for (int i = 0; i < pesoInicial - 1; i++) {
            soma += Character.getNumericValue(numero.charAt(i)) * peso--;
        }

        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
