package DeepSkill.DesignPatterns.DependencyInjectionExample;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerName(int id) {
        System.out.println("Customer name for id: " + id + ": " + customerRepository.findCustomerByID(id));
    }
}


