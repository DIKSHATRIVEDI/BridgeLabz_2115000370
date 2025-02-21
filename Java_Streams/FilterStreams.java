import java.io.*;
public class FilterStreams{
    public static void main(String[] args){
        String inp="Source.txt";
        String out="output.txt";
        try{
            fileToLowercase(inp,out);
            System.out.println("File conversion completed successfully");
        }catch(IOException e){
            System.err.println("Error --> "+e.getMessage());
        }
    }
    public static void fileToLowercase(String inp,String out)throws IOException{
        try(BufferedReader br=new BufferedReader(new FileReader(inp));
            BufferedWriter bw=new BufferedWriter(new FileWriter(out))){
            String str;
            while((str=br.readLine())!=null){
                bw.write(str.toLowerCase());
                bw.newLine();
            }
        }
    }
}