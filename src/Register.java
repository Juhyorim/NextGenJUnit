public class Register {
    private ProductCatalog catalog;
    private Sale sale;

    public Sale getSale() {
        return sale;
    }

    public Register(ProductCatalog catalog) {  this.catalog = catalog; }
//    Sale instance s 가 생성된다(instance creation).
//        s 는 Register와 연관된다(association formed).
//        s의 속성이 초기화된다.
    public void makeNewSale() {
        sale = new Sale();
    }
    //    SalesLineItem의 인스턴스 sli가 생성된다(instance creation).
//        sli는 current Sale과 연관된다(association formed).
//        sli.quantity는 quantity가 된다(attribute modification).
//        sli는 ProductDescription과 itemID를 기반으로 연관된다.(association formed).
    // itemID, quantity -> description, total
    public void enterltem(ItemID id, int quantity) {
        ProductSpecification spec = catalog.getSpecification(id);
        sale.makeLineltem(spec, quantity);
    }

    // Sale.isComplete가 true가 된다(attribute modification).
    // total with taxes
    public void endSale()  {   sale.becomeComplete(); }

//    Payment의 인스턴스인 p가 생성된다(instance creation).
//        p.amountTendered는 amount가 된다(attribute modification).
//        p는 current Sale과 연관된다(association formed).
//        current Sale은 Store와 연관된다(association formed to add it to the historical log of completed sales)
// amount -> change due, receipt
    public void makePayment(Money cashTendered) {

        sale.makePayment(cashTendered);
    }
}

