package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class SearchRecords{
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
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter employee name to search --> ");
        String name=sc.nextLine().trim();
        boolean found=false;
        try(CSVReader reader=new CSVReader(new FileReader(path))){
            String[] col;
            boolean isHeader=true;
            while((col=reader.readNext())!=null){
                if(isHeader){
                    isHeader=false;
                    continue;
                }
                if(col[1].trim().equalsIgnoreCase(name)){
                    System.out.println("Employee Found!");
                    System.out.println("Department --> "+col[2]);
                    System.out.println("Salary --> $"+col[3]);
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.println("Employee not found.");
            }
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
        }
    }
}