import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Medicine> medicines;
    private List<Order> orders;
    private List<Customer> customers;

    public Pharmacy(String name, String address) {
        this.name = name;
        this.address = address;
        this.employees = new ArrayList<>();
        this.medicines = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(int id) {
        medicines.removeIf(m -> m.getId() == id);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void generateReport() {
        System.out.println("Pharmacy: " + name + ", Address: " + address);
        System.out.println("\nEmployees:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - " + employee.getRole());
        }
        System.out.println("\nMedicines:");
        for (Medicine medicine : medicines) {
            System.out.println(medicine.getName() + " - " + medicine.getQuantity() + " in stock, Expiry: "
                    + medicine.getExpiryDate());
        }
        System.out.println("\nCustomers:");
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " - Phone: " + customer.getPhoneNumber());
        }
        System.out.println("\nOrders:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getId() + ", Customer: " + order.getCustomer().getName());
        }
    }
}
