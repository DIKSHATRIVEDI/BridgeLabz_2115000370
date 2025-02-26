package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
class Persons{
    private String name;
    private int age;
    private String email;
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getEmail(){return email;}
    @Override
    public String toString(){
        return "Persons(name='"+name+"', age="+age+", email='"+email+"')";
    }
}
public class FilterRecordsJSON{
    public static void main(String[] args){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            List<Persons> people=objectMapper.readValue(new File("datas.json"),new TypeReference<List<Persons>>(){});
            List<Persons> filteredPeople=people.stream()
                    .filter(person->person.getAge()>25)
                    .collect(Collectors.toList());
            System.out.println("People with age > 25 --> ");
            filteredPeople.forEach(System.out::println);
        }catch(IOException e){
            System.out.println("Error reading JSON file --> "+e.getMessage());
        }
    }
}