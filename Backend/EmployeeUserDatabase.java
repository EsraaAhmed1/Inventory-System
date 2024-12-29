/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Arwa Mohamed
 */
public class EmployeeUserDatabase extends Database{
    public EmployeeUserDatabase(String filename) {
        super(filename);
    }
    @Override
    public EmployeeUser createRecordFrom(String line){

        String[] recordsdata = line.split(",");

        EmployeeUser e1 = new  EmployeeUser(recordsdata[0], recordsdata[1], recordsdata[2], recordsdata[3],recordsdata[4]);
        return e1;
    }

}
