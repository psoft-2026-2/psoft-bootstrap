public record Endereco(String rua, String cidade, String estado, String cep) {
    @Override
    public String toString() {
        return rua + ", " + cidade + " - " + estado + " (" + cep + ")";
    }
}