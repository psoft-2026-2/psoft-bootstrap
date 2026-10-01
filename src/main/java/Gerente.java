public class Gerente implements Papel {

    private Time time;

    public Gerente(Time t) {
        this.time = t;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public Papel getPapel() {
        return this;
    }
}
