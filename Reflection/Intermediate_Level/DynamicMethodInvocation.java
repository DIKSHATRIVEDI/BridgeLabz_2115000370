import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
class MathOperations{
    public int add(int a,int b){
        return a+b;
    }
    public int subtract(int a,int b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
}
public class DynamicMethodInvocation{
    public static void main(String[] args)throws Exception{
        MathOperations mathOpr=new MathOperations();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter method name to call between --> add, subtract and multiply.  --> ");
        String methodName=sc.nextLine();
        System.out.println("Enter first argument --> ");
        int arg1=sc.nextInt();
        System.out.println("Enter second argument --> ");
        int arg2=sc.nextInt();
        try{
            Method method=MathOperations.class.getMethod(methodName,int.class,int.class);
            int result=(int)method.invoke(mathOpr,arg1,arg2);
            System.out.println("Result --> "+result);
        }catch(NoSuchMethodException e){
            System.err.println("Method not found --> "+e.getMessage());
        }catch(Exception e){
            System.err.println("Error invoking method --> "+e.getMessage());
        }
    }
}