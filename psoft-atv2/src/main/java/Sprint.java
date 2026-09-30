public class Sprint {
    private int numero;
    private Time time;
    private Pessoa liderTemporario;

    public Sprint(int numero, Time time, Pessoa liderTemporario) {
        if (!time.getDesenvolvedores().contains(liderTemporario)) {
            throw new IllegalArgumentException("O líder da sprint deve ser um desenvolvedor pertencente ao time.");
        }
        this.numero = numero;
        this.time = time;
        this.liderTemporario = liderTemporario;
    }

    public int getNumero() {
        return numero;
    }

    public Time getTime() {
        return time;
    }

    public Pessoa getLiderTemporario() {
        return liderTemporario;
    }
}
