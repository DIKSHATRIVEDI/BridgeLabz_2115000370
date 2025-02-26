package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
public class PrintKeysValues{
    public static void main(String[] args){
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            JsonNode jsonNode=objectMapper.readTree(new File("data2.json"));
            display(jsonNode);
        }catch(IOException e){
            System.out.println("Error reading JSON file --> "+e.getMessage());
        }
    }
    private static void display(JsonNode jsonNode){
        if(jsonNode.isObject()){
            Iterator<Map.Entry<String,JsonNode>> iterator=jsonNode.fields();
            while(iterator.hasNext()){
                Map.Entry<String,JsonNode> entry=iterator.next();
                System.out.println(entry.getKey()+" --> "+entry.getValue());
            }
        }
    }
}