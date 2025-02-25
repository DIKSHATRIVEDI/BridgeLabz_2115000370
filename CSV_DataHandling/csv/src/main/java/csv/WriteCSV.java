package csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV{
    public static void main(String[] args){
        String path="E:\\BridgeLab\\CSV_DataHandling\\employees.csv";
        File file=new File(path);
        if (!file.exists()) {
            System.out.println("File not found --> " + file.getAbsolutePath());
            return;
        }
        else {
            System.out.println("File found --> " + file.getAbsolutePath());
        }
        try(CSVWriter writer=new CSVWriter(new FileWriter(path))){
            String[] header={"ID","Name","Department","Salary"};
            String[] row1={"104","Riya","Finance","62000"};
            String[] row2={"105","Jiya","Sales","58000"};
            String[] row3={"104","Siya","Finance","62000"};
            String[] row4={"105","Piya","Sales","58000"};
            writer.writeNext(header);
            writer.writeNext(row1);
            writer.writeNext(row2);
            writer.writeNext(row3);
            writer.writeNext(row4);
        }catch(IOException e){
            e.printStackTrace();
        }
        try(CSVReader reader=new CSVReader(new FileReader(path))){
            String[] col;
            while((col=reader.readNext())!=null){
                if(col.length==4){
                    System.out.println("ID --> "+col[0]);
                    System.out.println("Name --> "+col[1]);
                    System.out.println("Department --> "+col[2]);
                    System.out.println("Salary --> "+col[3]);
                    System.out.println();
                }else{
                    System.out.println("Invalid size of columns: "+String.join(",",col));
                }
            }
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
        }
    }
}