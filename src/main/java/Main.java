public class Main {
    public static void main(String[] args) {
        Empresa e = new Empresa("apple", 1);
        System.out.println(e.criarProduto("iphone", 10));
        e.criarProgramador("Ana", "11");
        e.criarProgramador("Bia", "2");
        e.criarProgramador("Caio", "3");
        e.criarTime("Alpha", 1, "111", "App");
        Time t = e.buscarTime("Alpha");
        System.out.println(t.addMembro(e.buscarProgramador("222")));
        System.out.println(t.addMembro(e.buscarProgramador("333")));
        System.out.println(t.mudaLider(e.buscarProgramador("222")));
        System.out.println(t.novaSprint("Sprint 2", 7));
        System.out.println(e.buscarProgramador("333").promover(new Gerente()));
        System.out.println(e.definirProductOwner("333"));
        System.out.println(e);
    }
}