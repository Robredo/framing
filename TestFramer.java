import java.io.*;

class TestFramer{

  private final static int mask = 0xFF;
  public static void printByteArray(byte[] val){
    StringBuilder str = new StringBuilder();
    for(byte b : val){
      str.append(b & mask).append(" ");
    }
    System.out.println(str.toString());
  }

  public static void main(String[] args) throws FileNotFoundException, IOException{
    InputStream in1 = new FileInputStream("./test.txt");
    InputStream in = new FileInputStream("./test.txt");
    Framer delimiter_framer = new DelimFramer(in1);
    ByteArrayOutputStream delimiter_out = new ByteArrayOutputStream();
    byte [] delimiter_in = new byte[5]; 
    in.read(delimiter_in);
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    in.read();
    delimiter_in = new byte[5]; 
    in.read(delimiter_in);
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    in.read();
    delimiter_in = new byte[1]; 
    in.read(delimiter_in);
    delimiter_framer.frameMsg(delimiter_in, delimiter_out);
    printByteArray(delimiter_out.toByteArray()); 
    printByteArray(delimiter_framer.nextMsg()); 
    printByteArray(delimiter_framer.nextMsg()); 
    printByteArray(delimiter_framer.nextMsg()); 
  }
}
