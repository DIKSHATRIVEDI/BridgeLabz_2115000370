package json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CSVToJSON{
    public static void main(String[] args){
        String csvFile="data.csv";
        String jsonFile="data.json";
        ObjectMapper objectMapper=new ObjectMapper();
        try(FileReader reader=new FileReader(csvFile);
            CSVParser csvParser=new CSVParser(reader,CSVFormat.DEFAULT.withFirstRecordAsHeader())){
            ArrayNode jsonArray=objectMapper.createArrayNode();
            for(CSVRecord record:csvParser){
                ObjectNode jsonObject=objectMapper.createObjectNode();
                for(String header:csvParser.getHeaderMap().keySet()){
                    jsonObject.put(header,record.get(header));
                }
                jsonArray.add(jsonObject);
            }
            String jsonOutput=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            objectMapper.writeValue(new File(jsonFile),jsonArray);
            System.out.println("CSV converted to JSON successfully");
            System.out.println(jsonOutput);
        }catch(IOException e){
            System.out.println("Error --> "+e.getMessage());
        }
    }
}