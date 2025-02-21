import java.io.*;
class WriterThread extends Thread{
    private PipedOutputStream pos;
    public WriterThread(PipedOutputStream pos){
        this.pos=pos;
    }
    @Override
    public void run(){
        try(DataOutputStream dos=new DataOutputStream(pos)){
            for(int i=1;i<=5;i++){
                dos.writeUTF("Message "+i);
                System.out.println("Written --> Message "+i);
                Thread.sleep(500);
            }
        }
        catch(IOException|InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ReaderThread extends Thread{
    private PipedInputStream pis;
    public ReaderThread(PipedInputStream pis){
        this.pis=pis;
    }
    @Override
    public void run(){
        try(DataInputStream dis=new DataInputStream(pis)){
            while(true){
                String message=dis.readUTF();
                System.out.println("Read --> "+message);
            }
        }
        catch(EOFException e){
            System.out.println("End of stream reached.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
public class PipedStreams{
    public static void main(String[] args){
        try{
            PipedOutputStream pos=new PipedOutputStream();
            PipedInputStream pis=new PipedInputStream(pos);
            WriterThread writer=new WriterThread(pos);
            ReaderThread reader=new ReaderThread(pis);
            writer.start();
            reader.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}