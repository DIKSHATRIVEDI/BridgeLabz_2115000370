package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class ValidateJSONStructure{
    public static void main(String[] args){
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            JsonNode jsonNode=objectMapper.readTree(new File("data.json"));
            if(jsonNode.has("name")&&jsonNode.get("name").isTextual()
                    &&jsonNode.has("age")&&jsonNode.get("age").isInt()
                    &&jsonNode.has("email")&&jsonNode.get("email").isTextual()){
                System.out.println("JSON is valid!");
                System.out.println("Name --> "+jsonNode.get("name").asText());
                System.out.println("Age --> "+jsonNode.get("age").asInt());
                System.out.println("Email --> "+jsonNode.get("email").asText());
            }else{
                System.out.println("Invalid JSON structure!");
            }
        }catch(IOException e){
            System.out.println("Error reading JSON file --> "+e.getMessage());
        }
    }
}