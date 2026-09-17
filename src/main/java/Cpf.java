import java.util.regex.Pattern;

public class Cpf {
    private String numeroCpf;

    // Para fins de simplificação da atividade, verificação consiste em:
   // verificar se a String é composta por 11 números (com ou sem os "." e o "-").
    public Cpf(String numeroCpf) throws IllegalArgumentException {
        Pattern formatoValido = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$");
        if (formatoValido.matcher(numeroCpf).matches()) {
            this.numeroCpf = numeroCpf;
        } else {
            throw new IllegalArgumentException("CPF INVÁLIDO");
        }
    }

}