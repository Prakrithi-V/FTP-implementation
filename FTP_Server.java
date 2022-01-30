import java.io.*;
import java.net.*;
class FTP_Server
{
    public static void main(String args[]) 
    {
        try
        {
            ServerSocket servsocket = new ServerSocket(1025); 
            BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter File Name");
            String file = dis.readLine();
            System.out.println(file + " file is transferring");
            File myfile = new File(file);
            while(true)
            {
                Socket sock = servsocket.accept();
                byte[] mybytearray = new byte[(int)myfile.length()];
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myfile));
                bis.read(mybytearray, 0, mybytearray.length);
                OutputStream os = sock.getOutputStream();
                os.write(mybytearray, 0, mybytearray.length);
                System.out.println(file + " file is transferred");
                os.flush();
                bis.close();
                sock.close();
                servsocket.close();
            }
        }
        catch(IOException e)
        {
            System.out.println("IO: " + e.getMessage());
        }
    }

}