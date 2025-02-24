import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject{}
class SimpleDIContainer{
    private final Map<Class<?>,Object> map=new HashMap<>();
    public void register(Class<?> cls)throws Exception{
        Object obj=cls.getDeclaredConstructor().newInstance();
        map.put(cls,obj);
    }
    public void injectDependencies()throws Exception{
        for(Object obj:map.values()){
            for(Field field:obj.getClass().getDeclaredFields()){
                if(field.isAnnotationPresent(Inject.class)){
                    field.setAccessible(true);
                    field.set(obj,map.get(field.getType()));
                }
            }
        }
    }
    public <T> T getInstance(Class<T> cls){
        return cls.cast(map.get(cls));
    }
}
class Service{
    public void serve(){
        System.out.println("Service is running...");
    }
}
class Client{
    @Inject
    private Service service;
    public void execute(){
        service.serve();
    }
}
public class DependencyInjection{
    public static void main(String[] args)throws Exception{
        SimpleDIContainer container=new SimpleDIContainer();
        container.register(Service.class);
        container.register(Client.class);
        container.injectDependencies();
        Client client=container.getInstance(Client.class);
        client.execute();
    }
}