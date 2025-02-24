import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed{
    String value();
}
class User{
    private String role;
    public User(String role){
        this.role=role;
    }
    public String getRole(){
        return role;
    }
}
class Service{
    @RoleAllowed("ADMIN")
    public void adminOnlyMethod(){
        System.out.println("Admin method executed");
    }
    public void openMethod(){
        System.out.println("Open method executed");
    }
}
class AccessController{
    public static void invokeMethod(User user,Object obj,String methodName){
        try{
            Method method=obj.getClass().getMethod(methodName);
            RoleAllowed annotation=method.getAnnotation(RoleAllowed.class);
            if(annotation!=null && !annotation.value().equals(user.getRole())){
                System.out.println("Access Denied!");
                return;
            }
            method.invoke(obj);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class RoleBasedAccessControl{
    public static void main(String[] args){
        User adminUser=new User("ADMIN");
        User regularUser=new User("USER");
        Service service=new Service();
        System.out.println("Admin trying to access --> ");
        AccessController.invokeMethod(adminUser,service,"adminOnlyMethod");
        System.out.println("User trying to access --> ");
        AccessController.invokeMethod(regularUser,service,"adminOnlyMethod");
    }
}