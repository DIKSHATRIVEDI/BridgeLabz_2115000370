import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}
class User{
    @MaxLength(10)
    private String username;
    public User(String username){
        validateMaxLength(this,username);
        this.username=username;
    }
    private void validateMaxLength(User user,String value){
        try{
            Field field=User.class.getDeclaredField("username");
            MaxLength annotation=field.getAnnotation(MaxLength.class);
            if(annotation!=null && value.length()>annotation.value()){
                throw new IllegalArgumentException("Username exceeds max length of "+annotation.value()+" characters");
            }
        }catch(NoSuchFieldException e){
            e.printStackTrace();
        }
    }
    public String getUsername(){
        return username;
    }
}
public class MaxLengthAnnotation{
    public static void main(String[] args){
        try{
            User user1=new User("RiyaRashi");
            System.out.println("User1 created --> "+user1.getUsername());
            User user2=new User("VeryLongUsername");
        }catch(IllegalArgumentException e){
            System.err.println("Exception --> "+e.getMessage());
        }
    }
}