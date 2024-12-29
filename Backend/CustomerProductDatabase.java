/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Arwa Mohamed
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends Database{
    public CustomerProductDatabase(String filename) {
        super(filename);
    }
    @Override
    public CustomerProduct createRecordFrom(String line) {
            String x[]=line.split(",");
            String SSN=x[0];
            String productID=x[1];
            String y[]=x[2].split("-");
            LocalDate date= LocalDate.of(Integer.parseInt(y[2]),Integer.parseInt(y[1]),Integer.parseInt(y[0]));
            CustomerProduct c=new CustomerProduct(SSN,productID,date);
            return c;

    }

}
