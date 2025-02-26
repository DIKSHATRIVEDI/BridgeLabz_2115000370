package json;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
class Person{
    private String name;
    private int age;
    private String email;
    public Person(String name,int age,String email){
        this.name=name;
        this.age=age;
        this.email=email;
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
}
public class JavaObjectToJSONArray{
    public static void main(String[] args){
        try{
            List<Person> people=Arrays.asList(
                    new Person("Riya",22,"riya@example.com"),
                    new Person("Jiya",23,"jiya@example.com"),
                    new Person("Siya",24,"siya@example.com")
            );
            ObjectMapper objectMapper=new ObjectMapper();
            String jsonArray=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);
            System.out.println(jsonArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}