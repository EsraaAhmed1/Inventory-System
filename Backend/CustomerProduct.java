/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * 
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CustomerProduct implements Datatype {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }


    public String getCustomerSSN() {
        return customerSSN;
    }

//    public void setCustomerSSN(String customerSSN) {
//        this.customerSSN = customerSSN;
//    }

    public String getProductID() {
        return productID;
    }

//    public void setProductID(String productID) {
//        this.productID = productID;
//    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

//    public void setPurchaseDate(LocalDate purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }

    @Override
    public String lineRepresentation() {
        return customerSSN + "," + productID + "," + dateFormatter.format(purchaseDate);
    }

    @Override
    public String getSearchKey() {

        return customerSSN + "," + productID + "," + dateFormatter.format(purchaseDate);
    }
}
