import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}
class SoftwareModule{
    @BugReport(description="Null pointer exception on edge cases")
    @BugReport(description="Memory leak issue under heavy load")
    public void process(){
        System.out.println("Processing...");
    }
}
public class BugReportAnnotation{
    public static void main(String[] args){
        try{
            Class<?> clazz=SoftwareModule.class;
            Method method=clazz.getMethod("process");
            if(method.isAnnotationPresent(BugReports.class)){
                BugReports bugReports=method.getAnnotation(BugReports.class);
                for(BugReport bug:bugReports.value()){
                    System.out.println("Bug Description --> "+bug.description());
                }
            }
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }
    }
}