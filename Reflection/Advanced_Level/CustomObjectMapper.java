import java.lang.reflect.Field;
import java.util.Map;
public class CustomObjectMapper{
    public static <T> T toObject(Class<T> cls,Map<String,Object> map){
        try{
            T obj=cls.getDeclaredConstructor().newInstance();
            for(Map.Entry<String,Object> entry:map.entrySet()){
                String fieldName=entry.getKey();
                Object fieldValue=entry.getValue();
                try{
                    Field field=cls.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj,fieldValue);
                }catch(NoSuchFieldException e){
                    System.out.println("No field found --> "+fieldName);
                }
            }
            return obj;
        }catch(Exception e){
            throw new RuntimeException("Error mapping object",e);
        }
    }
    public static void main(String[] args){
        class Person{
            private String name;
            private int age;
            @Override
            public String toString(){
                return "Person --> (name='"+name+"', age="+age+")";
            }
        }
        Map<String,Object> map=Map.of("name","Riya","age",25);
        Person person=toObject(Person.class,map);
        System.out.println(person);
    }
}