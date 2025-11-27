package lab4;
import java.io.*;
import java.net.*;
public class chat_server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client...");
        Socket client = server.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String msgFromClient;
        while ((msgFromClient = in.readLine()) != null) {
            if (msgFromClient.equalsIgnoreCase("bye")) break;
            System.out.println("Client: " + msgFromClient);

            System.out.print("Server: ");
            String msgToClient = console.readLine();
            out.println(msgToClient);
            if (msgToClient.equalsIgnoreCase("bye")) break;
        }

        client.close();
        server.close();
        System.out.println("Chat ended.");
    }
}
