package csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UpdateValue{
    public static void main(String[] args){
        String input="E:\\BridgeLab\\CSV_DataHandling\\employees.csv";
        File file=new File(input);
        if (!file.exists()) {
            System.out.println("File not found --> " + file.getAbsolutePath());
            return;
        }
        else {
            System.out.println("File found --> " + file.getAbsolutePath());
        }       
        String output="updated_employees.csv";
        List<String[]> data=new ArrayList<>();
        try(CSVReader reader=new CSVReader(new FileReader(input))){
            String[] row;
            boolean isHeader=true;
            while((row=reader.readNext())!=null){
                if(isHeader){
                    data.add(row);
                    isHeader=false;
                    continue;
                }
                if(row[2].trim().equalsIgnoreCase("IT")){
                    double salary=Double.parseDouble(row[3].trim());
                    salary*=1.10;
                    row[3]=String.format("%.2f",salary);
                }
                data.add(row);
            }
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
            return;
        }
        try(CSVWriter writer=new CSVWriter(new FileWriter(output))){
            writer.writeAll(data);
            System.out.println("Updated file saved as --> "+output);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}