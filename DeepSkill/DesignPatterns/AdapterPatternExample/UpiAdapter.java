public class UpiAdapter implements PaymentProcessor {

    private UpiGateway upiGateway;

    public UpiAdapter(UpiGateway upiGateway) {
        this.upiGateway = upiGateway;
    }

    @Override
    public void processPayment(double amount) {
        upiGateway.sendPayment(amount);
    }
}