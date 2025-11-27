package lab4;

import java.io.*;
import java.net.*;
public class chat_client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msgFromServer;
        while (true) {
            System.out.print("Client: ");
            String msgToServer = console.readLine();
            out.println(msgToServer);
            if (msgToServer.equalsIgnoreCase("bye")) break;

            msgFromServer = in.readLine();
            if (msgFromServer == null || msgFromServer.equalsIgnoreCase("bye")) break;
            System.out.println("Server: " + msgFromServer);
        }

        socket.close();
        System.out.println("Chat ended.");
    }
}
