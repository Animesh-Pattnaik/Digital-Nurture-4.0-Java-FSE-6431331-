public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Added: " + emp);
        } else {
            System.out.println("Employee list is full. Cannot add more.");
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        System.out.println("\n=== Employee List ===");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int j = index; j < count - 1; j++) {
                employees[j] = employees[j + 1];
            }
            employees[count - 1] = null;
            count--;
            System.out.println("Deleted employee with ID: " + employeeId);
        } else {
            System.out.println("Employee ID " + employeeId + " not found.");
        }
    }
}