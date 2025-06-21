public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String customerId) {
        if (customerId.equals("12345")) {
            return "Animesh Kumar";
        } else if (customerId.equals("98765")) {
            return "Ankit Singh";
        } else {
            return "Customer not found";
        }
    }
}
