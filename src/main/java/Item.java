public class Item {
  private String name;
  private String id;
  private double unitPrice;

  public Item(String name, String id, double price) {
    this.name = name;
    this.id = id;
    this.unitPrice = price;
  }

  public double getPrice() {
    return this.unitPrice;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
