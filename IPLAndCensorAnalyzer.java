package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class IPLAndCensorAnalyzer{
    public static void processJson(String inputFile,String outputFile)throws IOException{
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(new File(inputFile));
        for(JsonNode match:jsonNode){
            ((ObjectNode)match).put("team1",censorTeamName(match.get("team1").asText()));
            ((ObjectNode)match).put("team2",censorTeamName(match.get("team2").asText()));
            ((ObjectNode)match).put("player_of_match","REDACTED");
        }
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile),jsonNode);
        System.out.println("JSON file processed successfully!");
    }
    public static void processCsv(String inputFile,String outputFile)throws IOException{
        Reader reader=new FileReader(inputFile);
        CSVFormat csvFormat=CSVFormat.DEFAULT.builder()
                .setHeader("match_id","team1","team2","score_team1","score_team2","winner","player_of_match")
                .setSkipHeaderRecord(true)
                .build();
        CSVParser csvParser=new CSVParser(reader,csvFormat);
        List<CSVRecord> records=new ArrayList<>();
        for(CSVRecord record:csvParser){
            records.add(record);
        }
        csvParser.close();
        writeCsv(outputFile,records);
        System.out.println("CSV file processed successfully");
    }
    private static void writeCsv(String outputFile,List<CSVRecord> records)throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(outputFile));
        CSVPrinter csvPrinter=new CSVPrinter(bw,CSVFormat.DEFAULT.builder()
                .setHeader("match_id","team1","team2","score_team1","score_team2","winner","player_of_match")
                .build());
        for(CSVRecord record:records){
            csvPrinter.printRecord(
                    record.get("match_id"),
                    censorTeamName(record.get("team1")),
                    censorTeamName(record.get("team2")),
                    record.get("score_team1"),
                    record.get("score_team2"),
                    record.get("winner"),
                    "REDACTED"
            );
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
    private static String censorTeamName(String teamName){
        String[] words=teamName.split(" ");
        return words[0]+" ***";
    }
    public static void main(String[] args)throws IOException{
        processJson("ipl_data.json","ipl_data_censored.json");
        processCsv("ipl_data.csv","ipl_data_censored.csv");
    }
}