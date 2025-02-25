import java.io.*;
import java.util.*;
public class ReadCSV {
    public static void main(String[] args){
        String path="students.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(path))){
            String line;
            while((line=br.readLine())!=null){
                String[] col=line.split(",");
                if(col.length==4){
                    System.out.println("ID --> "+col[0]);
                    System.out.println("Name --> "+col[1]);
                    System.out.println("Age --> "+col[2]);
                    System.out.println("Marks --> "+col[3]);
                    System.out.println();
                }
                else System.out.println("Invalid size of columns"+line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}