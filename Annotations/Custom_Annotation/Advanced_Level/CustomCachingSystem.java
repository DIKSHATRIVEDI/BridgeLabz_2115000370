import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult{}
class CacheHandler{
    private static final Map<String,Object> cache=new HashMap<>();
    public static Object invokeCachedMethod(Object obj,String methodName,Object... args){
        try{
            Method method=obj.getClass().getMethod(methodName,getParameterTypes(args));
            if(method.isAnnotationPresent(CacheResult.class)){
                String key=generateCacheKey(methodName,args);
                if(cache.containsKey(key)){
                    System.out.println("Returning cached result for: "+key);
                    return cache.get(key);
                }
                Object result=method.invoke(obj,args);
                cache.put(key,result);
                return result;
            }else{
                return method.invoke(obj,args);
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private static String generateCacheKey(String methodName,Object... args){
        StringBuilder keyBuilder=new StringBuilder(methodName);
        for(Object arg:args){
            keyBuilder.append("_").append(arg.toString());
        }
        return keyBuilder.toString();
    }
    private static Class<?>[] getParameterTypes(Object... args){
        return java.util.Arrays.stream(args).map(arg->arg instanceof Integer?int.class:arg.getClass()).toArray(Class<?>[]::new);
    }
}
class ExpensiveService{
    @CacheResult
    public int computeSquare(int num){
        System.out.println("Computing square for --> "+num);
        return num*num;
    }
}
public class CustomCachingSystem{
    public static void main(String[] args){
        ExpensiveService service=new ExpensiveService();
        System.out.println(CacheHandler.invokeCachedMethod(service,"computeSquare",5));
        System.out.println(CacheHandler.invokeCachedMethod(service,"computeSquare",5));
        System.out.println(CacheHandler.invokeCachedMethod(service,"computeSquare",10));
    }
}