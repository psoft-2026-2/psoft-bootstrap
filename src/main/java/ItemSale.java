public class ItemSale {
  private Item item;
  private int amount;

  public ItemSale(Item item, int amount) {
    this.item = item;
    this.amount = amount;
  }

  public double getSubTotal() {
    return this.amount * this.item.getPrice() * this.getDiscount();
  }

  private double getDiscount() {
    if (this.amount >= 20) {
      return 0.9;
    } else {
      return 1;
    }
  }

  public Item getItem() {
    return this.item;
  }
}
