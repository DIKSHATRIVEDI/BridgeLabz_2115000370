import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
public class GetClassInformation{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter class name --> ");
        String name=sc.nextLine();
        try{
            Class<?> cls=Class.forName(name);
            System.out.println("\nClass Information for --> "+cls.getName());
            System.out.println();
            System.out.println("\nConstructors --> ");
            Constructor<?>[] constructors=cls.getDeclaredConstructors();
            for(Constructor<?> constructor:constructors){
                System.out.println("\t"+constructor);
            }
            System.out.println("\nFields --> ");
            Field[] fields=cls.getDeclaredFields();
            for(Field field:fields){
                System.out.println("\t"+field);
            }
            System.out.println("\nMethods --> ");
            Method[] methods=cls.getDeclaredMethods();
            for(Method method:methods){
                System.out.println("\t"+method);
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found --> "+e.getMessage());
        }
        catch(Exception e){
            System.out.println("An error occurred --> "+e.getMessage());
            e.printStackTrace();
        }
    }
}