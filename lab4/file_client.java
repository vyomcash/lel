package lab4;

import java.io.*;
import java.net.*;
public class file_client {
    public static void main(String[] args) throws Exception {
        String serverIP = "127.0.0.1";
        int port = 5000;
        String filePath = "clientfiles/sample.txt";

        Socket socket = new Socket(serverIP, port);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        FileInputStream fis = new FileInputStream(filePath);

        dos.writeUTF(new File(filePath).getName()); // send file name

        byte[] buffer = new byte[4096];
        int count;
        while ((count = fis.read(buffer)) > 0) {
            dos.write(buffer, 0, count);
        }

        fis.close();
        dos.close();
        socket.close();
        System.out.println("File sent successfully.");
    }
}
