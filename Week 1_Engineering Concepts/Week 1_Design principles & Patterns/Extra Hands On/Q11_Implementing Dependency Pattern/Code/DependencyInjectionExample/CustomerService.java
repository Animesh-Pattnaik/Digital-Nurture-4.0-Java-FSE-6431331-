public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(String customerId) {
        String customerName = customerRepository.findCustomerById(customerId);
        System.out.println("Customer ID: " + customerId + ", Name: " + customerName);
    }
}
