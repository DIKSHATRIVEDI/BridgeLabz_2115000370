import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority="High",assignedTo="Riya")
    public void completeTask(){
        System.out.println("Task completed.");
    }
}
public class CustomAnnotation{
    public static void main(String[] args){
        try{
            Class<?> cls=TaskManager.class;
            Method method=cls.getMethod("completeTask");
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo taskInfo=method.getAnnotation(TaskInfo.class);
                System.out.println("Priority --> "+taskInfo.priority());
                System.out.println("Assigned To --> "+taskInfo.assignedTo());
            }
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}