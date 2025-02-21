import java.io.*;
public class BufferedStreams{
    public static void main(String[] args)throws IOException{
        String source="source.txt";
        String destBuffered="dest_buffered.txt";
        String destUnbuffered="dest_unbuffered.txt";
        long start,end;
        System.out.println("Copying with Buffered Streams ");
        start=System.nanoTime();
        try(FileInputStream fis=new FileInputStream(source);
            BufferedInputStream bis=new BufferedInputStream(fis);
            FileOutputStream fos=new FileOutputStream(destBuffered);
            BufferedOutputStream bos=new BufferedOutputStream(fos)){
            byte[] buffer=new byte[4096];
            int bytesRead;
            while((bytesRead=bis.read(buffer))!=-1){
                bos.write(buffer,0,bytesRead);
            }
        }
        end=System.nanoTime();
        System.out.println("Time taken Buffered --> "+(end-start)/1e6+" ms");
        System.out.println("Copying with Unbuffered Streams");
        start=System.nanoTime();
        try(FileInputStream fis=new FileInputStream(source);
            FileOutputStream fos=new FileOutputStream(destUnbuffered)){
            int data;
            while((data=fis.read())!=-1){
                fos.write(data);
            }
        }
        end=System.nanoTime();
        System.out.println("Time taken Unbuffered --> "+(end-start)/1e6+" ms");
    }
}