import java.io.*;
public class ReadLargeFile{
    public static void main(String[] args){
        String file="source.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String str;
            while((str=br.readLine())!=null){
                if(str.toLowerCase().contains("error")){
                    System.out.println(str);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}