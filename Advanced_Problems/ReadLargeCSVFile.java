package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
public class ReadLargeCSVFile{
    public static void main(String[] args){
        String file="large_data.csv";
        int batchSize=100;
        int totalRecords=0;
        try(CSVReader reader=new CSVReader(new FileReader(file))){
            String[] row;
            int batchCount=0;
            reader.readNext();
            while((row=reader.readNext())!=null){
                totalRecords++;
                batchCount++;
                processRow(row);
                if(batchCount==batchSize){
                    System.out.println("Processed "+totalRecords+" records so far...");
                    batchCount=0;
                }
            }
            System.out.println("Total records processed --> "+totalRecords);
        }catch(IOException|CsvValidationException e){
            System.out.println("Error reading file --> "+e.getMessage());
        }
    }
    private static void processRow(String[] row){
        if(row.length>0){
            System.out.println("Processing --> "+row[0]);
        }
    }
}