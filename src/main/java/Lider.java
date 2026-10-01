public class Lider implements Papel {

    private Sprint sprint;

    public Lider(Sprint s) {
        this.sprint = s;
    }

    public Sprint getSprint() {
        return sprint;
    }

    @Override
    public Papel getPapel() {
        return this;
    }
}
