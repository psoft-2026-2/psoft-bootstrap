package crud;

public class Cpf{

    private String cpf;

    public Cpf(String cpf){
        this.cpf = validaCpf(cpf);
    }

    public String validaCpf(String cpf){
        String[] chars = cpf.split("");

        int count = 0;
        for (String c : chars){
            if (c.matches("[0-9]")){
                count++;
            }
        }

        if (count != 11){
            throw new IllegalArgumentException("Cpf inválido!!");
        }else{
            return cpf;
        }
    }

    public String getcpf(){
        return cpf;
    }

    // métodos gerados automaticamente pela IDE
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cpf other = (Cpf) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }


}