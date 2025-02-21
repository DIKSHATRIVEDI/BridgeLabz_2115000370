import java.io.*;
public class ByteArrayStream{
    public static void main(String[] args){
        String inputPath="input.jpg";
        String outputPath="output.jpg";
        try{
            byte[] imageBytes=imageToArray(inputPath);
            ArrayToImage(imageBytes,outputPath);
            System.out.println("Image conversion completed successfully.");
        }
        catch(IOException e){
            System.err.println("Error --> "+e.getMessage());
        }
    }
    public static byte[] imageToArray(String imagePath)throws IOException{
        File file=new File(imagePath);
        try(FileInputStream fis=new FileInputStream(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream()){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=fis.read(buffer))!=-1){
                baos.write(buffer,0,bytesRead);
            }
            System.out.println("Image converted to byte array.");
            return baos.toByteArray();
        }
    }
    public static void ArrayToImage(byte[] imageBytes,String outputPath)throws IOException{
        try(ByteArrayInputStream bais=new ByteArrayInputStream(imageBytes);
            FileOutputStream fos=new FileOutputStream(outputPath)){
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=bais.read(buffer))!=-1){
                fos.write(buffer,0,bytesRead);
            }
            System.out.println("Byte array converted back to image.");
        }
    }
}