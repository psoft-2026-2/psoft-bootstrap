public class Email implements Contato {
    private String provedor;
    private String email;

    public Email(String provedor, String email) {
        this.provedor = provedor;
        this.email = email;
    }

    public String getProvedor() {
        return provedor;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean comunicar() {
        System.out.println("Enviando e-mail para: " + email);
        return true;
    }
}