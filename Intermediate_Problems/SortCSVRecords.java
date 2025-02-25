package csv;

import com.opencsv.*;
import java.io.*;
import java.util.*;
class Employee{
    private String id;
    private String name;
    private String department;
    private double salary;
    public Employee(String id,String name,String department,double salary){
        this.id=id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    @Override
    public String toString(){
        return id+" | "+name+" | "+department+" | "+salary;
    }
}
public class SortCSVRecords{
    public static void main(String[] args){
        String file="employees.csv";
        List<Employee> list=new ArrayList<>();
        try(CSVReader reader=new CSVReader(new FileReader(file))){
            List<String[]> records=reader.readAll();
            records.remove(0);
            for(String[] row:records){
                if(row.length<4)continue;
                String id=row[0].trim();
                String name=row[1].trim();
                String department=row[2].trim();
                double salary=Double.parseDouble(row[3].trim());
                list.add(new Employee(id,name,department,salary));
            }
        }catch(Exception e){
            System.err.println("Error reading CSV --> "+e.getMessage());
        }
        Collections.sort(list,new Comparator<Employee>(){
            @Override
            public int compare(Employee e1,Employee e2){
                return Double.compare(e2.getSalary(),e1.getSalary());
            }
        });
        System.out.println("Top 5 Highest Paid Employees --> ");
        for(int i=0;i<Math.min(5,list.size());i++){
            System.out.println(list.get(i));
        }
    }
}