public class Gerente implements Papel {

    @Override
    public String getFuncao() {
        return "Lider";
    }

    @Override
    public String realizaFuncao() {
        return "Gerenciando o projeto";
    }

}