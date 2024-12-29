/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * 
 */
public class ProductDatabase extends Database{
    public ProductDatabase(String filename) {
        super(filename);
    }
    @Override
    public Product createRecordFrom(String line) {
        String x[]=line.split(",");
        String Id=x[0];
        String Name=x[1];
        String manufacturer=x[2];
        String supplier=x[3];
        int quantity=Integer.parseInt(x[4]);
        float price=Float.parseFloat(x[5]);
        Product p=new Product(Id,Name,manufacturer,supplier,quantity,price);
        return p;
    }
}



