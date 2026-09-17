package crud;

public class Telefone{

    private String telefone;

    public Telefone (String telefone){
        this.telefone = validaTelefone(telefone);
    }

    public String validaTelefone(String telefone){
       String[] caracteres = telefone.split("");
       
       for (String c : caracteres){
                if ((!c.matches("[0-9]") && !c.equals("-") && !c.equals("+"))){
                    throw new IllegalArgumentException("Número inválido!");
                }
       }

       return telefone;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}