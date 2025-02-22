import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DateExtractor{
    public static void main(String[] args){
        String text="The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String regex="\\b\\d{2}/\\d{2}/\\d{4}\\b";
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