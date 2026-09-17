public class Bootstrap {

    public static void main(String[] args) {
        Pessoa p = new Pessoa("fulano", "xxxxxxxxx-xx", "xx xxxx-xxxx", "algo", 20);
        p.cadastraEndereco("a", "xxxxx-xxx" , "b", "centro", 1);
        p.cadastraEndereco("a", "xxxxx-xxx" , "b", "centro", 2);
        System.out.println(p.mostraEndereco(2));
    }
}
