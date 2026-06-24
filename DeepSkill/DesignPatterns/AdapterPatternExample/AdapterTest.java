public class AdapterTest {

    public static void main(String[] args) {

        PaymentProcessor paypal =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor upi =
                new UpiAdapter(new UpiGateway());


        paypal.processPayment(4200);
        upi.processPayment(6750);
        
    }
}