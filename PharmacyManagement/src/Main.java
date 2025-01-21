import java.util.*;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pharmacy pharmacy = new Pharmacy("HealthPlus Pharmacy", "Main Street, Bahir Dar");

        // Adding Employees
        System.out.println("Enter Employee Details:");
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();
        System.out.print("Enter Employee Role: ");
        String employeeRole = scanner.nextLine();
        Employee employee = new Employee(1, employeeName, employeeRole); // Employee ID can be dynamically managed
        pharmacy.addEmployee(employee);

        // Adding Customers
        System.out.println("\nEnter Customer Details:");
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String customerPhone = scanner.nextLine();
        Customer customer = new Customer(1, customerName, customerPhone); // Customer ID can be dynamically managed
        pharmacy.addCustomer(customer);

        // Adding Medicines
        System.out.println("\nEnter Medicine Details:");
        System.out.print("Enter Medicine Name: ");
        String medicineName = scanner.nextLine();
        System.out.print("Enter Medicine Price: ");
        double medicinePrice = scanner.nextDouble();
        System.out.print("Enter Medicine Quantity: ");
        int medicineQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Medicine Expiry Date (yyyy-MM-dd): ");
        String medicineExpiry = scanner.nextLine();
        Medicine medicine = new Medicine(1, medicineName, medicinePrice, medicineQuantity, medicineExpiry); // Medicine
                                                                                                            // ID can be
                                                                                                            // dynamically
                                                                                                            // managed
        pharmacy.addMedicine(medicine);

        // Display Pharmacy Information
        System.out.println("\nPharmacy Management System");
        pharmacy.generateReport();

        // Place an Order
        System.out.println("\nPlace an Order:");
        List<Medicine> orderMedicines = new ArrayList<>();
        orderMedicines.add(medicine); // For simplicity, adding the entered medicine. You can extend this logic.
        Order order = new Order(1, customer, orderMedicines); // Order ID can be dynamically managed
        pharmacy.addOrder(order);

        // Generate Invoice for the Order
        order.generateInvoice();

        // Update Medicine Stock
        try {
            System.out.print("\nEnter Quantity to Update for " + medicine.getName() + ": ");
            int quantityUpdate = scanner.nextInt();
            medicine.updateQuantity(medicine.getQuantity() - quantityUpdate);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Display Updated Pharmacy Report
        System.out.println("\nUpdated Pharmacy Report:");
        pharmacy.generateReport();

        // Process Order by Employee
        System.out.println("\nEmployee Processing Order:");
        employee.processOrder(order);

        // Handle Expiry Check
        System.out.println("\nMedicine Expiry Check:");
        System.out.println(medicine.getName() + " expired? " + medicine.checkExpiry());

        // Remove Medicine
        System.out.print("\nDo you want to remove a medicine? (yes/no): ");
        scanner.nextLine(); // Consume the leftover newline
        String removeMedicineResponse = scanner.nextLine();
        if (removeMedicineResponse.equalsIgnoreCase("yes")) {
            System.out.print("Enter Medicine ID to remove: ");
            int removeMedicineId = scanner.nextInt();
            pharmacy.removeMedicine(removeMedicineId);
        }

        // Final Pharmacy Report
        System.out.println("\nFinal Pharmacy Report:");
        pharmacy.generateReport();

        // Close the scanner
        scanner.close();
    }
}
