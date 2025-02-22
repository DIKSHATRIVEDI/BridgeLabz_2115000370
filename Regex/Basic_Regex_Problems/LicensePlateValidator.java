import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LicensePlateValidator{
    public static boolean isValidLicensePlate(String licensePlate){
        String regex="^[A-Z]{2}\\d{4}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(licensePlate);
        return matcher.matches();
    }
    public static void main(String[] args){
        String[] licensePlates={"AB1234","A12345","ab1234","ABC123","AB12345"};
        for(String licensePlate:licensePlates){
            System.out.println(licensePlate+" -> "+(isValidLicensePlate(licensePlate)?"Valid":"Invalid"));
        }
    }
}