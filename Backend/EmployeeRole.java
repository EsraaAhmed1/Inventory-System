/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import static Constants.FileNames.CUSTOMERPRODUCT_FILENAME;
import static Constants.FileNames.PRODUCT_FILENAME;

/**
 *
 * @author Arwa Mohamed
 */
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class EmployeeRole {
    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;
    DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public EmployeeRole() {
        productDatabase=new ProductDatabase(PRODUCT_FILENAME);
        customerProductDatabase=new CustomerProductDatabase(CUSTOMERPRODUCT_FILENAME);
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        productDatabase.insertRecord(new Product(productID, productName, manufacturerName, supplierName, quantity, price));
    }

    public Product[] getListOfProducts() {
        return productDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {

        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product p = (Product) productDatabase.getRecord(productID);
        if (p != null) {
            if (p.getQuantity() == 0)
                return false;
            else {
                p.setQuantity(p.getQuantity()-1);
                customerProductDatabase.insertRecord(new CustomerProduct(customerSSN, productID, purchaseDate));
            }
            return true;
        } else {
            System.out.println("not existing");
        }
        return false;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {

        String s = customerSSN + "," + productID + "," + dateformatter.format(purchaseDate);

        long daysDifference = ChronoUnit.DAYS.between(purchaseDate, returnDate);

        if (returnDate.isBefore(purchaseDate) || productDatabase.contains(productID) == false ||
                (customerProductDatabase.contains(s)) == false ||daysDifference > 14)
            return -1;
        else {
            Product p = (Product) productDatabase.getRecord(productID);
            p.setQuantity(p.getQuantity() + 1);
            customerProductDatabase.deleteRecord(s);
            return p.getPrice();
        }
    }
    public void logout() throws IOException
    {
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
