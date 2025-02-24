import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}
class Important{
    @ImportantMethod
    public void veryImportant(){
        System.out.println("Processing very important things");
    }
    @ImportantMethod(level="MEDIUM")
    public void mediumImportant(){
        System.out.println("Processing medium important things");
    }
    public void lessImportant(){
        System.out.println("Performing less important things");
    }
}
public class ImportantMethodAnnotation{
    public static void main(String[] args){
        Class<?> cls=Important.class;
        for(Method method:cls.getDeclaredMethods()){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod annotation=method.getAnnotation(ImportantMethod.class);
                System.out.println("Method --> "+method.getName()+"\nImportance Level --> "+annotation.level());
            }
        }
    }
}