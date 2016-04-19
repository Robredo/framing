import java.io.*;

public class DelimFramer implements Framer{
  private InputStream in;
  private static final char DELIMITER = '\n';

  public DelimFramer(InputStream in){
    this.in = in;
  }

  public void frameMsg(byte[] message, OutputStream out) throws IOException{
    for(byte b : message){
      if(b == DELIMITER)
        throw new IOException("Delimiter is part of message");
    } 
    out.write(message);
    out.write(DELIMITER); 
    out.flush();
  }

  public byte[] nextMsg() throws IOException{
    ByteArrayOutputStream message = new ByteArrayOutputStream();
    int nextByte;
    while((nextByte = this.in.read()) != DELIMITER){
      if(nextByte == -1){
        if(message.size() == 0) {
          return null;
        }else{
          throw new EOFException("Delimiter is not part of message");
        }
      }
      message.write(nextByte);
    }
    return message.toByteArray();
  }
}
