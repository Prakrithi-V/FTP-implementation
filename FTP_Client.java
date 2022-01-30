import java.io.*;
import java.net.*;
class FTP_Client
{
    public static void main(String args[])
    {
        try
        {
            Socket cSocket = new Socket("localhost", 1025);
            byte[] bytearray = new byte[1024];
            InputStream inps = cSocket.getInputStream();
            BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter File Name to Store the Transferred File");
            String file = dis.readLine();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new  BufferedOutputStream(fos);
            int bytesread = inps.read(bytearray, 0, bytearray.length);
            bos.write(bytearray, 0, bytesread);
            System.out.println("File Received!");
            bos.close();
            cSocket.close();
        }
        catch(IOException e)
        {
            System.out.println("IO: " + e.getMessage());
        }
    }
}