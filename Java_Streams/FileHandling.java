import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class FileHandling{
    public static void main(String[] args){
        String sourceFileName="source.txt";
        String destinationFileName="destination.txt";
        try(FileInputStream fis=new FileInputStream(sourceFileName);
            FileOutputStream fos=new FileOutputStream(destinationFileName)){
            int data;
            while((data=fis.read())!=-1){
                fos.write(data);
            }
            System.out.println("File copied successfully!");
        }
        catch(IOException e){
            if(e instanceof java.io.FileNotFoundException){
                System.out.println("Source file not found --> "+sourceFileName);
            }
            else{
                System.err.println("An error occurred during file processing --> "+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}