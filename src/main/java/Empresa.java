import java.util.List;

public class Empresa {
    private List<Time> times;
    private List<Sprint> sprints;
    private ProductOwner productOwner;

    public Empresa(Lider lider) {
        this.productOwner = (ProductOwner) lider;
    }

    public void addtime(Time time){
        this.times.add(time);
    }

    public void addProj(Sprint sprints){
        this.sprints.add(sprints);
    }

    public void finalizarProj(Sprint sprints){
        this.sprints.remove(sprints);
        System.out.println("sprints finalizado!");
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    

}
