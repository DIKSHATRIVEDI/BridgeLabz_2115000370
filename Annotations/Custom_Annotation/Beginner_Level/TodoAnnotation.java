import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class Tasks{
    @Todo(task="Implement authentication",assignedTo="Riya",priority="HIGH")
    public void implementAuth(){
        System.out.println("Implementing authentication");
    }
    @Todo(task="Optimize database queries",assignedTo="Siya")
    public void optimizeDB(){
        System.out.println("Optimizing database queries");
    }
    @Todo(task="Design frontend",assignedTo="Jiya",priority="LOW")
    public void designFrontend(){
        System.out.println("Designing Frontend");
    }
}
public class TodoAnnotation{
    public static void main(String[] args){
        Class<?> cls=Tasks.class;
        System.out.println("Pending Tasks --> ");
        for(Method method:cls.getDeclaredMethods()){
            if(method.isAnnotationPresent(Todo.class)){
                Todo todo=method.getAnnotation(Todo.class);
                System.out.println("Task --> "+todo.task()+"\nAssigned To --> "+todo.assignedTo()+"\nPriority --> "+todo.priority());
            }
        }
    }
}