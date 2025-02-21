import java.io.*;
import java.util.*;
class Employee implements Serializable{
    private static final long serialVersionUID=1L;
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id,String name,String department,double salary){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public void display(){
        System.out.println("ID --> "+id+", Name --> "+name+", Dept --> "+department+", Salary --> "+salary);
    }
}
public class Serialization{
    private static final String file="employees.ser";
    public static void main(String[] args){
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(101,"Riya","Tech",50000));
        employees.add(new Employee(102,"Jiya","Marketing",60000));
        employees.add(new Employee(103,"Siya","Finance",70000));
        serializeEmployees(employees);
        List<Employee> deserializedEmployees=deserializeEmployees();
        System.out.println("\nDeserialized Employee List --> ");
        for(Employee emp:deserializedEmployees){
            emp.display();
        }
    }
    public static void serializeEmployees(List<Employee> employees){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(employees);
            System.out.println("Employee list serialized successfully");
        }

        catch(IOException e){
            System.err.println("Error during serialization --> "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(){
        List<Employee> employees=new ArrayList<>();
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file))){
            Object obj=ois.readObject();
            if(obj instanceof List<?>){
                employees=(List<Employee>)obj;
                System.out.println("Employee list deserialized successfully.");
            }
            else{
                System.err.println("Unexpected data type in file.");
            }
        }
        catch(IOException|ClassNotFoundException e){
            System.err.println("Error during deserialization --> "+e.getMessage());
        }
        return employees;
    }
}