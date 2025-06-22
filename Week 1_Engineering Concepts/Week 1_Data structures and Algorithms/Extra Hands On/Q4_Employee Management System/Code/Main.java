public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E101", "Adi", "Manager", 50000));
        manager.addEmployee(new Employee("E102", "Hari", "Developer", 40000));
        manager.addEmployee(new Employee("E103", "Deepak", "Tester", 35000));

        manager.displayAllEmployees();

        Employee e = manager.searchEmployee("E102");
        if (e != null) {
            System.out.println("\nFound: " + e);
        } else {
            System.out.println("\nEmployee not found.");
        }

        manager.deleteEmployee("E103");

        manager.displayAllEmployees();
    }
}
