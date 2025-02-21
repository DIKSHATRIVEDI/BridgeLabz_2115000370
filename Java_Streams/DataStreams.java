import java.io.*;
class Student{
    int rollNumber;
    String name;
    double gpa;
    public Student(int rollNumber,String name,double gpa){
        this.rollNumber=rollNumber;
        this.name=name;
        this.gpa=gpa;
    }
    public void display(){
        
        System.out.println("Roll Number --> "+rollNumber+", Name --> "+name+", GPA --> "+gpa);
    }
}
public class DataStreams{
    private static final String file="students.dat";
    public static void main(String[] args){
        Student[] students={
                new Student(101,"Riya",3.8),
                new Student(102,"Jiya",3.5),
                new Student(103,"Siya",3.9)
        };
        writeStudentData(students);
        readStudentData();
    }
    public static void writeStudentData(Student[] students){
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(file))){
            for(Student s:students){
                dos.writeInt(s.rollNumber);
                dos.writeUTF(s.name);
                dos.writeDouble(s.gpa);
            }
            System.out.println("Student data saved successfully.");
        }
        catch(IOException e){
            System.err.println("Error writing to file --> "+e.getMessage());
        }
    }
    public static void readStudentData(){
        try(DataInputStream dis=new DataInputStream(new FileInputStream(file))){
            System.out.println("\nRetrieving Student Data --> ");
            while(dis.available()>0){
                int rollNumber=dis.readInt();
                String name=dis.readUTF();
                double gpa=dis.readDouble();
                Student s=new Student(rollNumber,name,gpa);
                s.display();
            }
        }
        catch(IOException e){
            System.err.println("Error reading from file --> "+e.getMessage());
        }
    }
}