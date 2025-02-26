package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
public class JSONToXML{
    public static void main(String[] args){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode jsonNode=objectMapper.readTree(new File("data.json"));
            XmlMapper xmlMapper=new XmlMapper();
            String xml=xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(xml);
        }catch(IOException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}

