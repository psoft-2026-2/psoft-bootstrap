package entity;

public class Pagamento {
	
	private double valor;
	private boolean pago;
	
	public Pagamento() {
		this.valor = 0;
		this.pago = false;
	}
	
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public void realizarPagamento(double valor) {
		this.valor = valor;
		this.pago = true;
	}

}
