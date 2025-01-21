import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<Medicine> medicines;

    public Order(int id, Customer customer, List<Medicine> medicines) {
        this.id = id;
        this.customer = customer;
        this.medicines = medicines;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void generateInvoice() {
        double total = 0;
        System.out.println("\nInvoice for Order ID: " + id);
        System.out.println("Customer: " + customer.getName());
        for (Medicine medicine : medicines) {
            System.out.println(medicine.getName() + " - $" + medicine.getPrice() + " x " + medicine.getQuantity());
            total += medicine.getPrice() * medicine.getQuantity();
        }
        System.out.println("Total: $" + total);
    }
}
