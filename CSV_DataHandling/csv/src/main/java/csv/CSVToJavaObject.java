package csv;
import java.io.*;
import java.util.*;
class Student{
    private String name;
    private int age;
    private String email;
    public Student(String name,int age,String email){
        this.name=name;
        this.age=age;
        this.email=email;
    }
    @Override
    public String toString(){
        return "Student(name='"+name+"', age="+age+", email='"+email+"')";
    }
}
public class CSVToJavaObject{
    public static List<Student> readCSV(String file){
        List<Student> list=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String line;
            int lineNumber=0;
            while((line=br.readLine())!=null){
                lineNumber++;
                String[] values=line.split(",");
                if(lineNumber==1){
                    continue;
                }
                if(values.length<3){
                    System.out.println("Skipping invalid row at line "+lineNumber+" --> "+line);
                    continue;
                }
                String name=values[0].trim();
                int age;
                try{
                    age=Integer.parseInt(values[1].trim());
                }catch(NumberFormatException e){
                    System.out.println("Skipping invalid row at line "+lineNumber+" --> Invalid age format");
                    continue;
                }
                String email=values[2].trim();
                list.add(new Student(name,age,email));
            }
        }catch(IOException e){
            System.out.println("Error reading file --> "+e.getMessage());
        }
        return list;
    }
    public static void main(String[] args){
        String file="student.csv";
        List<Student> students=readCSV(file);
        for(Student student:students){
            System.out.println(student);
        }
    }
}