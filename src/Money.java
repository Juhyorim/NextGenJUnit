public class Money {
    double money;

    @Override
    public String toString() {
        return "" + money;
    }

    public Money(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
//payment.getAmount().minus(getTotal())
    public Money minus(Money total) {
        return new Money(money - total.getMoney()); //TODO
    }

    public Money times(double quantity) {
        return new Money(money * quantity);  //TODO
    }

    public void add(Money subtotal) {
        money += subtotal.getMoney();
    }
}