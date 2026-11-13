public class Rota {
    private  String origem;
    private  String destino;
    

    public Rota(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }


    public float calcularDistancia() {
        return 100.0f;  //Valor simulado, o calculo da distancia deve ser espeficidado pela Empresa
    }

    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
}
