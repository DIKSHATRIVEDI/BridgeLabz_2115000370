import java.lang.reflect.Method;
public class MethodExecutionTiming{
    public static void calculateTime(Object speed,String methodName){
        try{
            Method method=speed.getClass().getMethod(methodName);
            long start=System.nanoTime();
            method.invoke(speed);
            long end=System.nanoTime();
            long duration=(end-start)/1_000_000;
            System.out.println(methodName+" took "+duration+" ms to execute");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        class MethodSpeed{
            public void fastMethod(){
                System.out.println("Fast method executed");
            }
            public void slowMethod()throws InterruptedException{
                Thread.sleep(1000);
                System.out.println("Slow method executed");
            }
        }
        MethodSpeed speed=new MethodSpeed();
        calculateTime(speed,"fastMethod");
        calculateTime(speed,"slowMethod");
    }
}