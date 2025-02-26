package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJSONExtractField {
    public static void main(String[] args){
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode jsonNode=objectMapper.readTree((new File("data.json")));
            System.out.println(jsonNode.get("name").asText());
            System.out.println(jsonNode.get("email").asText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
