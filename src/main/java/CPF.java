public class CPF {

    private String cpf;

    public CPF(String cpf){
        this.cpf = cpf;
    }

    public String getCPF(){
        return this.cpf;
    }

    public boolean validaCPF(){
        if (this.cpf == null) {
            return false;
        }
        String cpf = this.cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;
        if ((cpf.charAt(9) - '0') != digito1) {
            return false;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;
        return (cpf.charAt(10) - '0') == digito2;
    }


}
