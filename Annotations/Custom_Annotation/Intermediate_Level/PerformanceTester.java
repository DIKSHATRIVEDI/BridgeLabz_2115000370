import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}
class PerformanceTester{
    @LogExecutionTime
    public void intensiveTask(){
        long sum=0;
        for(int i=0;i<1000000;i++){
            sum+=i;
        }
        System.out.println("Intensive Task Done");
    }
    @LogExecutionTime
    public void simpleTask(){
        System.out.println("Simple Task Done");
    }
    public static void main(String[] args)throws Exception{
        PerformanceTester tester=new PerformanceTester();
        for(Method method:PerformanceTester.class.getDeclaredMethods()){
            if(method.isAnnotationPresent(LogExecutionTime.class)){
                long startTime=System.nanoTime();
                method.invoke(tester);
                long endTime=System.nanoTime();
                long executionTime=endTime-startTime;
                System.out.println(method.getName()+" Execution Time --> "+executionTime+" nanoseconds");
            }
        }
    }
}