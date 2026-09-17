public class Cpf {
    private final String cpf;

    public Cpf(String cpf) {
        if (!validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF deve ter 11 digitos");
        }
        this.cpf = cpf;
        
    }

    public String getCpf() {
        return this.cpf;
    }

    private boolean validarCpf(String cpf) {
        if (cpf == null) return false;
        if (cpf.length() != 11) return false;

        for (int i = 0; i < cpf.length(); i++) {
            char c = cpf.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}