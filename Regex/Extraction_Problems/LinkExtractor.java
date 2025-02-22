import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LinkExtractor{
    public static void main(String[] args){
        String text="Visit https://www.google.com and http://example.org for more info.";
        String regex="(https?://\\S+)";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        StringBuilder sb=new StringBuilder();
        while(matcher.find()){
            sb.append(matcher.group()).append(", ");
        }
        if(sb.length()>0){
            sb.delete(sb.length()-2,sb.length());
        }
        System.out.println(sb.toString());
    }
}