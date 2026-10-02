public class Customer {
  private String name;
  private Tier subscriptionTier;

  public Customer(String name) {
    this.name = name;
    this.subscriptionTier = Tier.STANDARD;
  }

  public void upgradeSubscription() {
    if (this.subscriptionTier != Tier.PREMIUM)
      this.subscriptionTier = Tier.PREMIUM;
  }

  public void downgradeSubscription() {
    if (this.subscriptionTier != Tier.STANDARD)
      this.subscriptionTier = Tier.STANDARD;
  }

  public double getSubscriptionDiscount() {
    if (this.subscriptionTier == Tier.PREMIUM) {
      return 0.9;
    } else {
      return 1;
    }
  }

  public String getName() {
    return this.name;
  }
}
