import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map productSpecifications = new HashMap();

    public ProductCatalog() {
        // sample data
        ItemID id1 = new ItemID(1);
        ItemID id2 = new ItemID(2);
        ItemID id3 = new ItemID(3);

        Money price1 = new Money(3000);
        Money price2 = new Money(40000);
        Money price3 = new Money(1000);

        ProductSpecification ps1;
        ProductSpecification ps2;
        ProductSpecification ps3;

        ps1 = new ProductSpecification(id1, price1, "캔커피");
        productSpecifications.put(id1.getItemID(), ps1);
        ps2 = new ProductSpecification(id2, price2, "온풍기");
        productSpecifications.put(id2.getItemID(), ps2);
        ps3 = new ProductSpecification(id3, price3, "포도젤리");
        productSpecifications.put(id3.getItemID(), ps3);
    }

    public ProductSpecification getSpecification(ItemID id) {
        return (ProductSpecification) productSpecifications.get(id.getItemID());
    }
}

