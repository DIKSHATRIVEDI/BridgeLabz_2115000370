package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class ReadCSV{
    public static void main(String[] args){
        String path="E:\\BridgeLab\\CSV_DataHandling\\students.csv";
        File file=new File(path);
        if (!file.exists()) {
            System.out.println("File not found --> " + file.getAbsolutePath());
            return;
        }
        else {
            System.out.println("File found --> " + file.getAbsolutePath());
        }
        try(CSVReader reader=new CSVReader(new FileReader(path))){
            String[] col;
            while((col=reader.readNext())!=null){
                if(col.length==4){
                    System.out.println("ID --> "+col[0]);
                    System.out.println("Name --> "+col[1]);
                    System.out.println("Age --> "+col[2]);
                    System.out.println("Marks --> "+col[3]);
                    System.out.println();
                }else{
                    System.out.println("Invalid size of columns --> "+String.join(",",col));
                }
            }
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
        }
    }
}