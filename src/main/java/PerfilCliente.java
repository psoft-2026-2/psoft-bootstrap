public enum PerfilCliente {
    STANDARD(0),
    PREMIUM(5);

    private final int desconto; // em %

    PerfilCliente(int desconto) {
        this.desconto = desconto;
    }

    public int getDesconto() {
        return desconto;
    }
}