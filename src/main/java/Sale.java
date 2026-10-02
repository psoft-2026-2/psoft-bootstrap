import java.util.ArrayList;
import java.util.List;

public class Sale {
  private List<ItemSale> items;
  private Customer customer;
  private SaleStatus status;

  public Sale(Customer customer) {
    this.customer = customer;
    this.items = new ArrayList<>();
    this.status = SaleStatus.PENDING;
  }

  public double getFinalPrice() {
    double total = 0.0;
    for (ItemSale itemSale : this.items) {
      total += itemSale.getSubTotal();
    }

    total *= this.customer.getSubscriptionDiscount();

    return total;
  }

  public void addItem(ItemSale item) {
    this.items.add(item);
  }

  public void removeItem(String id) {
    this.items.removeIf(saleItem -> saleItem.getItem().getId().equals(id));
  }

  public SaleStatus getStatus() {
    return this.status;
  }

  public void pay() {
    if (this.status == SaleStatus.PENDING)
      this.status = SaleStatus.COMPLETED;
  }

  public void cancel() {
    if (this.status == SaleStatus.PENDING)
      this.status = SaleStatus.CANCELED;
  }
}
