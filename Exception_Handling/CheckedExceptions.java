import java.io.*;
public class CheckedExceptions{
    public static void main(String[] args){
        String file="data.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }
        }
        catch(IOException e){
            System.out.println("File not found");
        }
    }
}