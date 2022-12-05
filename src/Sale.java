import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sale {
    private List lineltems = new ArrayList();
    private Date date = new Date();
    private boolean isComplete = false;

    public Payment getPayment() {
        return payment;
    }

    private Payment payment;

    public Money getBalance()  {
        return payment.getAmount().minus(getTotal());
    }

    public void becomeComplete() {
        isComplete = true;
    }

    public boolean isComplete() {   return isComplete;   }

    public void makeLineltem(ProductSpecification spec, int quantity) {
        lineltems.add(new SalesLineltem(spec, quantity));
    }

    public Money getTotal()
    {
        Money total = new Money(0);
        Iterator i = lineltems.iterator( ) ;

        while ( i.hasNext() ){
            SalesLineltem sli = (SalesLineltem) i.next();

            total.add( sli.getSubtotal() );

        }

        return total;
    }

    public void makePayment(Money cashTendered) {
        payment = new Payment(cashTendered);
    }

    public void getReceipt() {
        System.out.println("<영수증>");
        System.out.println("날짜: " + date);
        System.out.println();
        Iterator i = lineltems.iterator( ) ;
        while ( i.hasNext() ){
            SalesLineltem sli = (SalesLineltem) i.next();

            System.out.print("" + sli.getDescription() + "\t");
            System.out.print(sli.getQuantity() + " 개: \t");
            System.out.println("" + sli.getSubtotal() + " 원");
        }
        System.out.println("========================================");
        System.out.println("총합: \t\t" + getTotal()+" 원");
        System.out.println("지불한 금액: \t" + payment.getAmount().getMoney()+" 원");
        System.out.println("잔돈: \t\t" + getBalance() +" 원");
    }

}


