public class Pagamento {

    private boolean realizou;

    public Pagamento(boolean realizou){
        this.realizou = realizou;
    }

    public boolean getRealizou(){
        return this.realizou;
    }

    public void setRealizou(boolean novo){
        this.realizou = novo;
    }
}
