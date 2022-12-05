public class SalesLineltem {
    private int quantity;

    private ProductSpecification productSpec;
    public int getQuantity() {
        return quantity;
    }

    public SalesLineltem(ProductSpecification spec, int quantity) {
        this.productSpec = spec;
        this.quantity = quantity;
    }

    public Money getSubtotal() {
        return productSpec.getPrice().times(quantity);
    }

    public String getDescription() {
        return productSpec.getDescription();
    }
}
