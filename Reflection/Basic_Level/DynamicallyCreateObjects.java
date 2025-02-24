import java.lang.reflect.Constructor;
class Student{
    private String name;
    public Student(String name){
        this.name=name;
    }
    public void display(){
        System.out.println("Student Name --> "+name);
    }
}
public class DynamicallyCreateObjects{
    public static void main(String[] args)throws Exception{
        Class<?> cls=Student.class;
        Constructor<?> constructor=cls.getConstructor(String.class);
        Student student=(Student)constructor.newInstance("Riya");
        student.display();
    }
}