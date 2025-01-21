import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String expiryDate;

    public Medicine(int id, String name, double price, int quantity, String expiryDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void updateQuantity(int newQuantity) {
        if (newQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = newQuantity;
    }

    public boolean checkExpiry() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expiry = LocalDate.parse(expiryDate, formatter);
        return !expiry.isAfter(LocalDate.now());
    }
}
