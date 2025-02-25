package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FilterRecords{
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
            boolean isHeader=true;
            while((col=reader.readNext())!=null){
                if(isHeader){
                    isHeader=false;
                    continue;
                }
                try{
                    int marks=Integer.parseInt(col[3].trim());
                    if(marks>=80){
                        System.out.println("ID --> "+col[0]+"\tName --> "+col[1]+"\tAge --> "+col[2]+"\tMarks --> "+col[3]);
                    }
                    else{
                        System.out.println("Record is not greater than 80 --> "+String.join(", ",col));
                    }
                }catch(NumberFormatException e){
                    System.out.println("Number format exception --> "+String.join(", ",col));
                }
            }
        }catch(IOException|CsvValidationException e){
            e.printStackTrace();
        }
    }
}
