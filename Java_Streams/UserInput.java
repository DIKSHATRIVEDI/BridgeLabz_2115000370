import java.io.*;
public class UserInput{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name --> ");
        String name=br.readLine();
        System.out.print("Enter your age --> ");
        int age=Integer.parseInt(br.readLine());
        System.out.print("Enter your favorite programming language --> ");
        String language=br.readLine();
        try(FileWriter fw=new FileWriter("user_info.txt")){
            fw.write("Name --> "+name+"\n");
            fw.write("Age --> "+age+"\n");
            fw.write("Favorite Language --> "+language+"\n");
            System.out.println("User information saved to user_info.txt");
        }
        catch(IOException e){
            System.err.println("Error writing to file --> "+e.getMessage());
        }
    }
}