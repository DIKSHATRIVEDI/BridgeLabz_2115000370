import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class WordCensor{
    public static void main(String[] args){
        String text="This is a damn bad example with some stupid words.";
        Set<String> badWords=new HashSet<>(Arrays.asList("damn","stupid"));
        String censoredText=censorWords(text,badWords);
        System.out.println(censoredText);
    }
    public static String censorWords(String text,Set<String> badWords){
        String[] words=text.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            String lowerCaseWord=word.toLowerCase().replaceAll("[^a-zA-Z]","");
            if(badWords.contains(lowerCaseWord)){
                sb.append("**** ");
            }
            else{
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }
}