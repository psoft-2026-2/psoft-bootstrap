public class Desenvolvedor implements Papel {
    private int anosExperiencia;

    public Desenvolvedor(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public String getNome() {
        return "Desenvolvedor";
    }

    @Override
    public void executar() {
        System.out.println("-> Escrevendo código, realizando testes e resolvendo tarefas do backlog.");
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }
}