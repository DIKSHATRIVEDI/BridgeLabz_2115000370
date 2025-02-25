package csv;

import java.io.*;
import java.util.*;

public class MergeCSV{
    public static void mergeCSVFiles(String file1,String file2,String outputFile){
        Map<String, Students> map=new HashMap<>();
        try(BufferedReader br=new BufferedReader(new FileReader(file1))){
            String line;
            int lineNumber=0;
            while((line=br.readLine())!=null){
                lineNumber++;
                String[] values=line.split(",");
                if(lineNumber==1)continue;
                if(values.length<3){
                    System.out.println("Skipping invalid row in "+file1+" --> "+line);
                    continue;
                }
                String id=values[0].trim();
                String name=values[1].trim();
                int age;
                try{
                    age=Integer.parseInt(values[2].trim());
                }catch(NumberFormatException e){
                    System.out.println("Skipping invalid age in "+file1+" --> "+line);
                    continue;
                }
                map.put(id,new Students(id,name,age));
            }
        }catch(IOException e){
            System.out.println("Error reading "+file1+" --> "+e.getMessage());
        }
        try(BufferedReader br=new BufferedReader(new FileReader(file2))){
            String line;
            int lineNumber=0;
            while((line=br.readLine())!=null){
                lineNumber++;
                String[] values=line.split(",");
                if(lineNumber==1)continue;
                if(values.length<3){
                    System.out.println("Skipping invalid row in "+file2+" --> "+line);
                    continue;
                }
                String id=values[0].trim();
                String marks=values[1].trim();
                String grade=values[2].trim();
                if(map.containsKey(id)){
                    map.get(id).setMarksAndGrade(marks,grade);
                }else{
                    System.out.println("Warning --> ID "+id+" found in "+file2+" but not in "+file1);
                }
            }
        }catch(IOException e){
            System.out.println("Error reading "+file2+" --> "+e.getMessage());
        }
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(outputFile))){
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for(Students student:map.values()){
                bw.write(student.toString());
                bw.newLine();
            }
            System.out.println("Merged CSV file created --> "+outputFile);
        }catch(IOException e){
            System.out.println("Error writing file --> "+e.getMessage());
        }
    }
    public static void main(String[] args){
        String file1="students1.csv";
        String file2="students2.csv";
        String outputFile="merged_students.csv";
        mergeCSVFiles(file1,file2,outputFile);
    }
}