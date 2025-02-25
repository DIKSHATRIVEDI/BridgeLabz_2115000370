import java.io.*;
import java.util.*;
public class CountCSV {
    public static void main(String[] args){
        String path="students.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(path))){
            String line;
            int count=0;
            while((line=br.readLine())!=null){
                String[] col=line.split(",");
                count=col.length;
                }

            System.out.println("count of records are --> "+(count-1));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}