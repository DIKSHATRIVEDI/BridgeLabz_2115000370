package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class MergeJSONObject{
    public static void main(String[] args){
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            String json1="{ \"name\": \"Riya\", \"age\": 22 }";
            String json2="{ \"email\": \"riya@example.com\", \"city\": \"Agra\" }";
            JsonNode node1=objectMapper.readTree(json1);
            JsonNode node2=objectMapper.readTree(json2);
            ObjectNode mergedNode=(ObjectNode)node1;
            mergedNode.setAll((ObjectNode)node2);
            String mergedJson=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode);
            System.out.println("Merged JSON -->\n"+mergedJson);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}