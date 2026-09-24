public enum Perfil {
    STANDARD(0.0f),
    PREMIUM(0.05f);

    public float desconto;

    private Perfil(float desconto) {
        this.desconto = desconto;
    }
}
