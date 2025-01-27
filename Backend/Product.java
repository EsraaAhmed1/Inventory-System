/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * 
 */
public class  Product implements Datatype {
    private String productID;
    private String productName;

    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

//    public String getProductID() {
//        return productID;
//    }
//
//    public void setProductId(String productId) {
//        this.productID = productID;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getManufacturerName() {
//        return manufacturerName;
//    }
//
//    public void setManufacturerName(String manufacturerName) {
//        this.manufacturerName = manufacturerName;
//    }
//
//    public String getSupplierName() {
//        return supplierName;
//    }
//
//    public void setSupplierName(String supplierName) {
//        this.supplierName = supplierName;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void returnProduct() {
        quantity++;
    }


    @Override
    public String lineRepresentation(){
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity+ "," + price;
    }

    @Override
    public String getSearchKey() {
        return productID;
    }


}
