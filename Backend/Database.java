/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * 
 */

import java.util.*;
import java.io.*;


abstract public class Database {
    private String filename;
    private ArrayList<Datatype> records;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<Datatype>();
        readFromFile();
    }

//    public String getFilename() {
//        return filename;
//    }

//    public void setFilename(String filename) {
//        this.filename = filename;
//    }

    public void readFromFile() {

        try {
            File file = new File(filename);
            try (Scanner sc = new Scanner(file)) {
                    while (sc.hasNextLine()){
                        records.add(createRecordFrom(sc.nextLine()));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error in opening the file");
        }
    }


    abstract public Datatype createRecordFrom(String line);

    public ArrayList<Datatype> returnAllRecords() {
        return records;
    }

    public void insertRecord(Datatype record)
    {
        String a=record.lineRepresentation();
        String x[]=a.split(",");
        if(contains(x[0]))
        {
            System.out.println("already existing ");
        }
        else records.add(record);


    }
    public boolean contains(String key) {
        for(Datatype record: records)
        {
            String con=record.getSearchKey();
            if(con.equals(key))
                return true;
        }
        return false;
    }

    public  Datatype getRecord(String key) {
        for(Datatype record: records)
        {
            String con=record.getSearchKey();
            if(con.equals(key))
                return record;
        }

        return null;
    }
    public void deleteRecord(String key)
    {
        if(contains(key))
            records.remove(getRecord(key));
        else System.out.println("not existing");
    }

    public  void saveToFile() throws IOException {

        int i;
        try {
            Formatter file = new Formatter(filename);
            file.flush();
            for (i = 0; i < records.size(); i++)
                file.format(records.get(i).lineRepresentation() + "\n");
            file.close();
        } catch (IOException e) {
            System.out.println("Error in file");
        }
    }
}


