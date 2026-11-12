public class Logistica {
    private static Logistica logistica;
    
    private Empresa empresaGerenciada; 

    private Logistica() {
        this.empresaGerenciada = new Empresa();
    }

    public static Logistica getLogistica() {
        if (logistica == null) {
            logistica = new Logistica();
        }
        return logistica;
    }

    public Empresa getEmpresaGerenciada() {
        return empresaGerenciada;
    }
}