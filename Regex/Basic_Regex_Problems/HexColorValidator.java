import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class HexColorValidator{
    public static boolean isValidHexColor(String hexColor){
        String regex="^#[0-9a-fA-F]{6}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(hexColor);
        return matcher.matches();
    }
    public static void main(String[] args){
        String[] hexColors={"#FFA500","#ff4500","#123","#abcdef","#000000"};
        for(String hexColor:hexColors){
            System.out.println(hexColor+" -> "+(isValidHexColor(hexColor)?"Valid":"Invalid"));
        }
    }
}