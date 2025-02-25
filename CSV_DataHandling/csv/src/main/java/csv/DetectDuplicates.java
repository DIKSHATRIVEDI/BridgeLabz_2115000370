package csv;

import java.io.*;
import java.util.*;
public class DetectDuplicates{
    public static void detectDuplicates(String file){
        Set<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber=0;
            while((line=br.readLine())!=null){
                lineNumber++;
                String[] values=line.split(",");
                if(lineNumber==1)continue;
                if(values.length==0)continue;
                String id=values[0].trim();
                if(set.contains(id)){
                    list.add(line);
                }else{
                    set.add(id);
                }
            }
            if(!list.isEmpty()){
                System.out.println("Duplicate records found --> ");
                for(String row:list){
                    System.out.println(row);
                }
            }else{
                System.out.println("No duplicate records found.");
            }
        }catch(IOException e){
            System.out.println("Error reading file --> "+e.getMessage());
        }
    }
    public static void main(String[] args){
        String file="students.csv";
        detectDuplicates(file);
    }
}