import java.util.regex.Pattern;
public class Telefone {
    
    private String telefone;

    public Telefone(String numeroTelefone) {
        setTelefone(numeroTelefone);
    }

    private boolean validaTelefone(String numeroTelefone) {
        Pattern telefoneValido = Pattern.compile("^\\d{11}$");
        return telefoneValido.matcher(numeroTelefone).matches();
    }

    public void setTelefone(String telefone) throws IllegalArgumentException {
        if (validaTelefone(telefone)) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("TELEFONE INVÁLIDO");
        }
    }
}
