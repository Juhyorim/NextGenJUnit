import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterTest {
    @Before
    @org.junit.Test
    public void test1_makeNewSale() {
        Store store = new Store();
        Register register = store.getRegister();
        register.makeNewSale();
        assertTrue("sale is not null", register.getSale() != null);
    }

    @org.junit.Test
    public void test2_enterltem() {
        Store store = new Store();
        Register register = store.getRegister();
        register.makeNewSale();
        ItemID itemID1 = new ItemID(1);
        Money price1 = store.getCatalog().getSpecification(itemID1).getPrice();
        register.enterltem(itemID1, 3);
        ItemID itemID2 = new ItemID(2);
        Money price2 = store.getCatalog().getSpecification(itemID2).getPrice();
        register.enterltem(itemID2, 2);

        assertTrue("saleLineItem total 같음", register.getSale().getTotal().getMoney() == price1.getMoney()  * 3 + price2.getMoney() * 2);
    }

    @org.junit.Test
    public void test3_endSale() {
        Store store = new Store();
        Register register = store.getRegister();
        register.makeNewSale();
        ItemID itemID = new ItemID(2);
        register.enterltem(itemID, 3);
        register.endSale();

        assertTrue("sale is complete", register.getSale().isComplete());
    }


    @org.junit.Test
    public void test4_makePayment() {

        Store store = new Store();
        Register register = store.getRegister();
        register.makeNewSale();
        ItemID itemID1 = new ItemID(1);
        Money price1 = store.getCatalog().getSpecification(itemID1).getPrice();
        register.enterltem(itemID1, 3);
        ItemID itemID2 = new ItemID(2);
        Money price2 = store.getCatalog().getSpecification(itemID2).getPrice();
        register.enterltem(itemID2, 2);
//
//        Store store = new Store();
//        Register register = store.getRegister();
//        register.makeNewSale();
//        ItemID itemID = new ItemID(2);
//        Money price = store.getCatalog().getSpecification(itemID).getPrice();
//        register.enterltem(itemID, 3);
        register.endSale();
        Money cashTendered = new Money(150000);
        register.makePayment(cashTendered);

        assertTrue("balance = total - payment", register.getSale().getBalance().getMoney() == cashTendered.getMoney() - register.getSale().getTotal().getMoney());
    }

    @org.junit.Test
    public void getReceipt() {
//        Store store = new Store();
//        Register register = store.getRegister();
//        register.makeNewSale();
//        ItemID itemID = new ItemID(2);
//        register.enterltem(itemID, 3);

        Store store = new Store();
        Register register = store.getRegister();
        register.makeNewSale();

        ItemID itemID1 = new ItemID(1);
        Money price1 = store.getCatalog().getSpecification(itemID1).getPrice();
        register.enterltem(itemID1, 3);
        ItemID itemID2 = new ItemID(2);
        Money price2 = store.getCatalog().getSpecification(itemID2).getPrice();
        register.enterltem(itemID2, 2);
        ItemID itemID3 = new ItemID(3);
        Money price3 = store.getCatalog().getSpecification(itemID3).getPrice();
        register.enterltem(itemID3, 1);

        register.endSale();
        Money cashTendered = new Money(150000);
        register.makePayment(cashTendered);
        register.getSale().getReceipt();
    }
}