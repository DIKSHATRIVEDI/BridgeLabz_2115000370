import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField{
    String name();
}
class User{
    @JsonField(name="user_name")
    private String username;
    @JsonField(name="user_age")
    private int age;
    public User(String username,int age){
        this.username=username;
        this.age=age;
    }
}
class JsonSerializer{
    public static String serialization(Object obj){
        Map<String,String> map=new HashMap<>();
        Field[] fields=obj.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            JsonField annotation=field.getAnnotation(JsonField.class);
            if(annotation!=null){
                try{
                    map.put(annotation.name(),field.get(obj).toString());
                }catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        return map.toString().replace("="," -> ").replace("{","{").replace("}","}").replace(",",", ");
    }
}
public class CustomSerializationAnnotation{
    public static void main(String[] args){
        User user=new User("Riya",30);
        String json=JsonSerializer.serialization(user);
        System.out.println("Serialized JSON --> "+json);
    }
}