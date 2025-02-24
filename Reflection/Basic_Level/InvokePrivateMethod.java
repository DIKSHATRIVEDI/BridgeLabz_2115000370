import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
class Calculator{
    private int multiply(int a, int b){
        return a*b;
    }
}
public class InvokePrivateMethod{
    public static void main(String[] args){
        try {
            Calculator calc=new Calculator();
            Class<?> cls=calc.getClass();
            Method method=cls.getDeclaredMethod("multiply",int.class,int.class);
            method.setAccessible(true);
            int res=(int) method.invoke(calc, 3, 8);
            System.out.println("Result --> " +res);
        } catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}