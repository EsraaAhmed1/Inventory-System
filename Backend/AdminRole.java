/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * 
 */

import static Constants.FileNames.EMPLOYEE_FILENAME;
import java.io.*;
import java.util.*;
public class AdminRole {

    public EmployeeUserDatabase database;

    public AdminRole() {
        database=new EmployeeUserDatabase(EMPLOYEE_FILENAME);
    }

    public void  addEmployee(String employeeId, String name, String email, String address, String phoneNumber)
    {
        database.insertRecord(new EmployeeUser( employeeId, name,  email, address, phoneNumber));
    }
    public EmployeeUser[]getListOfEmployees()
    {
        EmployeeUser [] listOfEmployees = new EmployeeUser[database.returnAllRecords().size()];
        listOfEmployees= database.returnAllRecords().toArray(listOfEmployees);
        return listOfEmployees;
    }
    public void removeEmployee(String key)
    {
        database.deleteRecord(key);
    }
    public void logout() throws IOException
    {
        database.saveToFile();
    }

}
