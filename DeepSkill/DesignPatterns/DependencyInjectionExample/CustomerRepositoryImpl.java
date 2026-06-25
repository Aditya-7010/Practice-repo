package DeepSkill.DesignPatterns.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository{
    
    @Override
    public String findCustomerByID(int id) {
        if (id == 1) {
            return "Customer found by id: " + id + " is Aditya";
        }
        else if (id == 2) {
            return "Customer found by id: " + id + " is Pia";
        }
        
        return "Customer not found by id: " + id;
    
    }
}
