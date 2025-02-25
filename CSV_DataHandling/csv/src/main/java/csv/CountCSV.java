package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CountCSV{
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
        int count=0;
        try(CSVReader reader=new CSVReader(new FileReader(path))){
            while(reader.readNext()!=null){
                count++;
            }
            System.out.println("Count of records --> "+(count-1));
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
        }
    }
}
