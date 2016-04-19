import java.io.*;

public class LengthFramer implements Framer{
  public static final int MAXLENGHT = 65535;
  public static final int BYTEMASK  = 0xff; 

  private InputStream in;

  public LengthFramer(InputStream in){
    this.in = in;
  }

  public void frameMsg(byte[] message, OutputStream out) throws IOException{
  }

  public byte[] nextMsg() throws IOException{
    return null;
  }
}

