package csv;

import java.io.*;
import java.util.regex.*;
public class ValidateCSV{
    private static final String email="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String phone="^[0-9]{10}$";
    public static void validateCSV(String filePath){
        Pattern emailPattern=Pattern.compile(email);
        Pattern phonePattern=Pattern.compile(phone);
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            int lineNumber=0;
            while((line=br.readLine())!=null){
                lineNumber++;
                String[] values=line.split(",");
                if(lineNumber==1){
                    continue;
                }
                if(values.length<2){
                    System.out.println("Invalid row at line "+lineNumber+" --> Missing columns");
                    continue;
                }
                String email=values[0].trim();
                String phone=values[1].trim();
                boolean isValidEmail=emailPattern.matcher(email).matches();
                boolean isValidPhone=phonePattern.matcher(phone).matches();
                if(!isValidEmail||!isValidPhone){
                    System.out.println("Invalid row at line "+lineNumber+" --> "+line);
                    if(!isValidEmail){
                        System.out.println("Invalid Email --> "+email);
                    }
                    if(!isValidPhone){
                        System.out.println("Invalid Phone Number --> "+phone);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error reading file --> "+e.getMessage());
        }
    }
    public static void main(String[] args){
        String file="data.csv";
        validateCSV(file);
    }
    
}
