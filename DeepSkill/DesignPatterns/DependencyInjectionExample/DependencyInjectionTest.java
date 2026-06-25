package DeepSkill.DesignPatterns.DependencyInjectionExample;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        customerService.displayCustomerName(1);
        customerService.displayCustomerName(2);
        customerService.displayCustomerName(4);

    }
}
