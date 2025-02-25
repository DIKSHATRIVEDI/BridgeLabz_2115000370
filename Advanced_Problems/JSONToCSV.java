package csv;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.*;
import java.util.*;
class Student2 {
    private String id;
    private String name;
    private int age;
    public Student2(){}
    public Student2(String id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public String getId(){return id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    @Override
    public String toString(){
        return id+","+name+","+age;
    }
}
public class JSONToCSV{
    private static final ObjectMapper mapper=new ObjectMapper();
    public static void jsonToCsv(String jsonFile,String csvFile){
        try{
            CollectionType listType=mapper.getTypeFactory().constructCollectionType(List.class, Student2.class);
            List<Student2> students=mapper.readValue(new File(jsonFile),listType);
            try(BufferedWriter writer=new BufferedWriter(new FileWriter(csvFile))){
                writer.write("ID,Name,Age");
                writer.newLine();
                for(Student2 student:students){
                    writer.write(student.toString());
                    writer.newLine();
                }
                System.out.println("JSON successfully converted to CSV --> "+csvFile);
            }
        }catch(IOException e){
            System.out.println("Error converting JSON to CSV --> "+e.getMessage());
        }
    }
    public static void csvToJson(String csvFile,String jsonFile){
        List<Student2> students=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(csvFile))){
            String line;
            int lineNumber=0;
            while((line=reader.readLine())!=null){
                lineNumber++;
                if(lineNumber==1)continue;
                String[] values=line.split(",");
                if(values.length<3)continue;
                students.add(new Student2(values[0].trim(),values[1].trim(),Integer.parseInt(values[2].trim())));
            }
            mapper.writeValue(new File(jsonFile),students);
            System.out.println("CSV successfully converted to JSON --> "+jsonFile);
        }catch(IOException e){
            System.out.println("Error converting CSV to JSON --> "+e.getMessage());
        }
    }
    public static void main(String[] args){
        String jsonFile="students.json";
        String csvFile="students.csv";
        String convertedJsonFile="students_converted.json";
        jsonToCsv(jsonFile,csvFile);
        csvToJson(csvFile,convertedJsonFile);
    }
}
