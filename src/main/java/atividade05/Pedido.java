package atividade05;

/**
 * Pedido 
 */
public class Pedido {
    private String Cliente; 
    private String enderecoOrigem; 
    private String enderecoDEestino;
    private double pesoKg; 
    private double distanciaKm; 
    private EstrategiaEntrega modalidadeEntrega;
    
    public Pedido(String cliente, String enderecoOrigem, String enderecoDEestino, double pesoKg, double distanciaKm,
            EstrategiaEntrega modalidade) {
        Cliente = cliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDEestino = enderecoDEestino;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.modalidadeEntrega = modalidade;
    }

    public double calcularCustoTotal(){
        return this.modalidadeEntrega.calcularCusto(this); 
    }

    public int calculaPrazoEstimato(){
        return  this.modalidadeEntrega.calcularPrazoDeEntrega(this); 
    }

    public String getCliente() {
        return Cliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDEestino() {
        return enderecoDEestino;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public EstrategiaEntrega getModalidade() {
        return this.modalidadeEntrega;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public void setEnderecoDEestino(String enderecoDEestino) {
        this.enderecoDEestino = enderecoDEestino;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
   
    // Permite alterar a modalidade antes do despacho
    public void setModalidade(EstrategiaEntrega modalidade) {
        this.modalidadeEntrega = modalidade;
        Logger.getInstancia().registrar("Modalidade de entrega alterada para o pedido de " + this.Cliente);
    } 

    
    
    

}
