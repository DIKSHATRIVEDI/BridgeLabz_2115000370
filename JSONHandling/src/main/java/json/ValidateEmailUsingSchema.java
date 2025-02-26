package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import java.io.File;
public class ValidateEmailUsingSchema{
    public static void main(String[] args){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode jsonData=objectMapper.readTree(new File("data.json"));
            JsonNode jsonSchema=objectMapper.readTree(new File("schema.json"));
            JsonSchemaFactory factory=JsonSchemaFactory.byDefault();
            JsonSchema schema=factory.getJsonSchema(jsonSchema);
            ProcessingReport report=schema.validate(jsonData);
            if(report.isSuccess()){
                System.out.println("Valid JSON");
            }else{
                System.out.println("Invalid JSON");
                System.out.println(report);
            }
        }catch(Exception e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}