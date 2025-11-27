package lab4;

import java.io.*;
import java.net.*;
public class file_server {
    public static void main(String[] args) throws Exception {
        int port = 5000;
        String savePath = "serverfiles/";

        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for file...");
        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String fileName = dis.readUTF();
        FileOutputStream fos = new FileOutputStream(savePath + fileName);

        byte[] buffer = new byte[4096];
        int count;
        while ((count = dis.read(buffer)) > 0) {
            fos.write(buffer, 0, count);
            if (count < 4096) break; // EOF for small files
        }

        fos.close();
        dis.close();
        client.close();
        server.close();
        System.out.println("File saved: " + savePath + fileName);
    }
}
