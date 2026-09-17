public enum Papel {
    CLIENTE,
    FUNCIONARIO;

    public static Papel fromString(String texto) {
        if (texto == null) {
            return CLIENTE;
        }

        try {
            return Papel.valueOf(texto.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}