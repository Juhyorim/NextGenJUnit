public class ProductSpecification {
    private ItemID id;
    private Money price;
    private String description;

    public ProductSpecification
            ( ItemID id, Money price, String description ) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public ProductSpecification get(ItemID id) {
        return this;
    }

    public ItemID getltemlD()  {  return id;  }

    public Money getPrice() {  return price;  }

    public String getDescription() {   return description;   }

//    public void put(ItemID itemID, ProductSpecification ps) {
//        // TODO
//    }
}